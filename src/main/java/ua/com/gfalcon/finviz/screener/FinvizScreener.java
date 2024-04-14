/*
 *  MIT License
 * -----------
 *
 * Copyright (c) 2016-2024 Oleksii V. KHALIKOV (http://gfalcon.com.ua)
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package ua.com.gfalcon.finviz.screener;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ua.com.gfalcon.finviz.exception.FinvizApiException;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.Signal;
import ua.com.gfalcon.finviz.validator.ScreenerFilterValidator;
import ua.com.gfalcon.finviz.validator.Validator;

/**
 * The FinvizScreener class implements the Screener interface and represents a screener
 * that uses the Finviz API to retrieve a list of tickers based on specified filter parameters.
 * The class provides methods to retrieve the tickers, the timestamp of the last result, and the count of tickers.
 */
public class FinvizScreener implements Screener {

    public static final String SCREENER_TICKERS_CLASS = "screener_tickers";
    public static final String TOTAL_TICKER_COUNT = "screener-total";
    private final List<FilterParameter> parameters;
    private final Signal signal;

    private final Set<String> tickers = new HashSet<>();
    private LocalDateTime lastResult = null;
    private int tickersCount = 0;

    /**
     * FinvizScreener is a class that represents a Finviz screener with a list of filter parameters.
     * It provides methods to retrieve the tickers, the result timestamp, and the number of tickers.
     *
     * @param parameters list of filter parameters.
     */
    public FinvizScreener(List<FilterParameter> parameters) {
        this(parameters, null);
    }

    /**
     * FinvizScreener is a class that represents a Finviz screener with a list of filter parameters and a signal.
     * It provides methods to retrieve the tickers, the result timestamp, and the number of tickers.
     *
     * @param parameters list of filter parameters.
     * @param signal represents one of the signals.
     */
    public FinvizScreener(List<FilterParameter> parameters, Signal signal) {
        Validator<List<FilterParameter>> validator = ScreenerFilterValidator.getInstance();
        if (validator.isValid(parameters)) {
            this.parameters = Collections.unmodifiableList(parameters);
            this.signal = signal;
        } else {
            throw new FinvizApiException("Incorrect list of parameters: " + parameters);
        }
    }

    /**
     * Returns a set of tickers based on the current state of the Finviz screener.
     * If the result timestamp is within the last 5 minutes, the stored tickers are returned.
     * Otherwise, a new request is made to the Finviz API using the provided filter parameters and signal,
     * and the tickers are retrieved from the response and stored for future use.
     * Note: An exception will be thrown if any error occurs during the retrieval process.
     *
     * @return a set of tickers
     * @throws FinvizApiException if an error occurs during the retrieval process
     */
    public Set<String> getTickers() {
        if (Objects.nonNull(getResultTimeStamp()) && (getResultTimeStamp().plusMinutes(5)
                .isAfter(LocalDateTime.now(ZoneId.of("GMT"))))) {
            return new HashSet<>(this.tickers);
        }

        int count;
        try {
            RequestBuilder builder = new RequestBuilder();
            String url = builder.build(this.parameters, this.signal);

            Document doc = Jsoup.connect(url)
                    .get();

            count = getTickerCount(doc);

            boolean nextLoad = false;
            for (int i = 1; i < count; i = i + 1000) {
                if (nextLoad) {
                    String newUrl = url + "&r=" + i;
                    doc = Jsoup.connect(newUrl)
                            .get();
                }

                tickers.addAll(getTickerSymbols(doc.getElementsByClass(SCREENER_TICKERS_CLASS)));

                nextLoad = true;
            }
        } catch (Exception e) {
            throw new FinvizApiException(e);
        }
        if (count < 0) {
            throw new FinvizApiException("The count is not recognized");
        }
        if (tickers.size() != count) {
            throw new FinvizApiException("Count mismatched");
        }
        this.lastResult = LocalDateTime.now(ZoneId.of("UTC"));
        this.tickersCount = tickers.size();
        return new HashSet<>(this.tickers);
    }

    protected static int getTickerCount(Document doc) {
        String countString = Optional.ofNullable(doc.getElementById(TOTAL_TICKER_COUNT))
                .map(Element::text)
                .orElse("");
        return parseCount(countString);
    }

    protected static List<String> getTickerSymbols(Elements tickersEl) {
        return tickersEl.stream()
                .map(element -> element.getElementsByTag("span"))
                .flatMap(Elements::stream)
                .map(Element::text)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static int parseCount(String str) {
        Optional<String> optional = Optional.of("-1");
        if (str.startsWith("Total:") && str.contains("#")) {
            optional = Optional.of(str)
                    .map(s -> s.split("#")[0])
                    .map(s -> s.substring("Total:".length()));
        }
        if (str.startsWith("#") && str.endsWith("Total") && str.contains("/")) {
            optional = Optional.of(str)
                    .map(s -> s.split("/")[1])
                    .map(s -> s.replace("Total", ""));
        }
        return optional.map(String::trim)
                .map(Integer::parseInt)
                .orElse(-1);
    }

    @Override
    public LocalDateTime getResultTimeStamp() {
        return this.lastResult;
    }

    @Override
    public int getTickersCount() {
        return this.tickersCount;
    }


}
