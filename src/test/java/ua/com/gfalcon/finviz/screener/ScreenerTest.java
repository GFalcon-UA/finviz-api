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

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static ua.com.gfalcon.finviz.screener.FinvizScreener.SCREENER_TICKERS_CLASS;
import static ua.com.gfalcon.finviz.screener.RequestBuilder.SCREENER_URL;
import ua.com.gfalcon.finviz.exception.FinvizApiException;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.Signal;
import ua.com.gfalcon.finviz.screener.filter.params.AverageVolume;
import ua.com.gfalcon.finviz.screener.filter.params.IPOdate;
import ua.com.gfalcon.finviz.screener.filter.params.Industry;
import ua.com.gfalcon.finviz.screener.filter.params.MarketCap;
import ua.com.gfalcon.finviz.screener.filter.params.OptionShort;

class ScreenerTest {

    @Test
    @Disabled("use to load page")
    void saveHtmlPageAsResource() {
        try {
            URL url = new URL("https://finviz.com/screener.ashx?v=411");
            String date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    .format(LocalDateTime.now());

            try (ReadableByteChannel readableByteChannel = Channels.newChannel(
                    url.openStream()); FileOutputStream fileOutputStream = new FileOutputStream(
                    "src/test/resources/" + date + ".html")) {
                fileOutputStream.getChannel()
                        .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Download failed.");
        }
    }

    @Test
    void tickerListAvailableTest() {
        Document page = getWebPage(SCREENER_URL);

        int tickerCount = FinvizScreener.getTickerCount(page);
        Elements tickers = page.getElementsByClass(SCREENER_TICKERS_CLASS);

        Assertions.assertAll(
                () -> Assertions.assertTrue(tickerCount > 0),
                () -> Assertions.assertNotNull(tickers),
                () -> Assertions.assertFalse(tickers.isEmpty()),
                () -> Assertions.assertFalse(FinvizScreener.getTickerSymbols(tickers).isEmpty()),
                () -> Assertions.assertTrue(StringUtils.isNotBlank(FinvizScreener.getTickerSymbols(tickers).get(0)))
        );
    }

    @Test
    void getTickers() {
        Screener screener = new FinvizScreener(tradingStocks(), Signal.TOP_GAINERS);

        Set<String> tickers = screener.getTickers();

        assertNotNull(screener.getResultTimeStamp());
    }

    @Test
    void noDuplicatesInFilterParameters() {
        Exception exception = assertThrows(FinvizApiException.class, () -> {
            new FinvizScreener(List.of(Industry.STOCK, Industry.ETF), Signal.NEW_LOW);
        });

        String expectedMessage = "Incorrect list of parameters: [STOCK, ETF]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public static List<FilterParameter> tradingStocks() {
        return List.of(MarketCap.SMALL_PLUS, Industry.STOCK, OptionShort.SHORTABLE, AverageVolume.OVER_500_K,
                IPOdate.MORE_THAN_5_YEARS_AGO//,
//                Price.FROM_1_TO_20
        );
    }

    private Document getWebPage(String url) {
        Document page = null;
        try {
            page = Jsoup.connect(url)
                    .get();
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertNotNull(page);
        return page;
    }

}