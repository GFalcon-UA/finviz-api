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

package ua.com.gfalcon.finviz.overview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ua.com.gfalcon.finviz.exception.FinvizApiException;

/**
 * The Stock class represents stock ticker information retrieved from Finviz.
 */
public class Stock {

    //<editor-fold desc="Variables">
    private final String ticker;
    private final String companyName;
    private final String sector;
    private final String industry;
    private final String geo;

    private final Map<String, String> stockDetails = new LinkedHashMap<>();

    private final String companyInfo;
    //</editor-fold>

    /**
     * Retrieves stock ticker information from Finviz.
     * <br>
     * {@code
     * Stock stock = new Stock("MSFT");
     * }
     *
     * @param ticker ticker of the company
     * @throws FinvizApiException when ticker cannot be found on Finviz
     */
    @SuppressWarnings("checkstyle:MethodLength")
    public Stock(String ticker) {
        Document doc = getStockInfo(ticker);
        if (!doc.getElementsByAttribute("data-ticker")
                .isEmpty()) {
            Elements elements = doc.select("a.tab-link");
            this.ticker = Optional.of(doc.getElementsByClass("quote-header_ticker-wrapper_ticker"))
                    .map(els -> els.get(0))
                    .orElse(new Element("div"))
                    .text();
            this.companyName = Optional.of(elements.get(0)).map(Element::text).orElse("");
            this.sector = Optional.of(elements.get(1)).map(Element::text).orElse("");
            this.industry = Optional.of(elements.get(2)).map(Element::text).orElse("");
            this.geo = Optional.of(elements.get(3)).map(Element::text).orElse("");

            stockDetails.put("Ticker", this.ticker);
            stockDetails.put("Company name", this.companyName);
            stockDetails.put("Sector", this.sector);
            stockDetails.put("Industry", this.industry);
            stockDetails.put("Geo", this.geo);

            elements = doc.getElementsByClass("snapshot-td2");
            List<String> collect = elements.stream()
                    .map(Element::text)
                    .collect(Collectors.toList());
            for (int i = 0; i < collect.size() - 1; i = i + 2) {
                stockDetails.put(collect.get(i), collect.get(i + 1));
            }

            this.companyInfo = wrapText(doc.select("td.fullview-profile")
                    .get(0)
                    .text());
        } else {
            throw new FinvizApiException("This ticker " + ticker + " cannot be found");
        }
    }

    //<editor-fold desc="Getters">

    public String getAtr() {
        return this.stockDetails.getOrDefault("ATR (14)", "");
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSector() {
        return sector;
    }

    public String getIndustry() {
        return industry;
    }

    public String getGeo() {
        return geo;
    }

    public String getAvgVolume() {
        return this.stockDetails.getOrDefault("Avg Volume", "");
    }

    public String getBeta() {
        return this.stockDetails.getOrDefault("Beta", "");
    }

    public String getBookSh() {
        return this.stockDetails.getOrDefault("Book/sh", "");
    }

    public String getCashSh() {
        return this.stockDetails.getOrDefault("Cash/sh", "");
    }

    public String getChange() {
        return this.stockDetails.getOrDefault("Change", "");
    }

    public String getCurrentRatio() {
        return this.stockDetails.getOrDefault("Current Ratio", "");
    }

    public String getDebtEq() {
        return this.stockDetails.getOrDefault("Debt/Eq", "");
    }

    public String getDividend() {
        return this.stockDetails.getOrDefault("Dividend Est.", "");
    }

    public String getDividendPercent() {
        return this.stockDetails.getOrDefault("Dividend TTM", "");
    }

    public String getDividentExDate() {
        return this.stockDetails.getOrDefault("Dividend Ex-Date", "");
    }

    public String getEarnings() {
        return this.stockDetails.getOrDefault("Earnings", "");
    }

    public String getEmployees() {
        return this.stockDetails.getOrDefault("Employees", "");
    }

    public String getEps() {
        return this.stockDetails.getOrDefault("EPS (ttm)", "");
    }

    public String getEpsNext5YPercent() {
        return this.stockDetails.getOrDefault("EPS next 5Y", "");
    }

    public String getEpsNextQ() {
        return this.stockDetails.getOrDefault("EPS next Q", "");
    }

    public String getEpsNextY() {
        return this.stockDetails.getOrDefault("EPS next Y", "");
    }

    public String getEpsPast5YPercent() {
        return this.stockDetails.getOrDefault("EPS past 5Y", "");
    }

    public String getEpsQQ() {
        return this.stockDetails.getOrDefault("EPS Q/Q", "");
    }

    public String getEpsSurprise() {
        return this.stockDetails.getOrDefault("EPS Surprise", "");
    }

    public String getEpsThisYPercent() {
        return this.stockDetails.getOrDefault("EPS this Y", "");
    }

    public String getEpsYyTtm() {
        return this.stockDetails.getOrDefault("EPS Y/Y TTM", "");
    }

    public String getForwardPE() {
        return this.stockDetails.getOrDefault("Forward P/E", "");
    }

    public String getGrossMargin() {
        return this.stockDetails.getOrDefault("Gross Margin", "");
    }

    public String getIncome() {
        return this.stockDetails.getOrDefault("Income", "");
    }

    public String getIndex() {
        return this.stockDetails.getOrDefault("Index", "");
    }

    public String getInsiderOwn() {
        return this.stockDetails.getOrDefault("Insider Own", "");
    }

    public String getInsiderTrans() {
        return this.stockDetails.getOrDefault("Insider Trans", "");
    }

    public String getInstOwn() {
        return this.stockDetails.getOrDefault("Inst Own", "");
    }

    public String getInstTrans() {
        return this.stockDetails.getOrDefault("Inst Trans", "");
    }

    public String getLtDebtEq() {
        return this.stockDetails.getOrDefault("LT Debt/Eq", "");
    }

    public String getMarketCap() {
        return this.stockDetails.getOrDefault("Market Cap", "");
    }

    public String getOperMargin() {
        return this.stockDetails.getOrDefault("Oper. Margin", "");
    }

    public String getOptionShort() {
        return this.stockDetails.getOrDefault("Option/Short", "");
    }

    public String getPayout() {
        return this.stockDetails.getOrDefault("Payout", "");
    }

    public String getPb() {
        return this.stockDetails.getOrDefault("P/B", "");
    }

    public String getPc() {
        return this.stockDetails.getOrDefault("P/C", "");
    }

    public String getPe() {
        return this.stockDetails.getOrDefault("P/E", "");
    }

    public String getPeg() {
        return this.stockDetails.getOrDefault("PEG", "");
    }

    public String getPerfHalfY() {
        return this.stockDetails.getOrDefault("Perf Half Y", "");
    }

    public String getPerfMonth() {
        return this.stockDetails.getOrDefault("Perf Month", "");
    }

    public String getPerfQuarter() {
        return this.stockDetails.getOrDefault("Perf Quarter", "");
    }

    public String getPerfWeek() {
        return this.stockDetails.getOrDefault("Perf Week", "");
    }

    public String getPerfYTD() {
        return this.stockDetails.getOrDefault("Perf YTD", "");
    }

    public String getPerfYear() {
        return this.stockDetails.getOrDefault("Perf Year", "");
    }

    public String getPfcf() {
        return this.stockDetails.getOrDefault("P/FCF", "");
    }

    public String getPrevClose() {
        return this.stockDetails.getOrDefault("Prev Close", "");
    }

    public String getPrice() {
        return this.stockDetails.getOrDefault("Price", "");
    }

    public String getProfitMargin() {
        return this.stockDetails.getOrDefault("Profit Margin", "");
    }

    public String getPs() {
        return this.stockDetails.getOrDefault("P/S", "");
    }

    public String getQuickRatio() {
        return this.stockDetails.getOrDefault("Quick Ratio", "");
    }

    public String getRecom() {
        return this.stockDetails.getOrDefault("Recom", "");
    }

    public String getRelVolume() {
        return this.stockDetails.getOrDefault("Rel Volume", "");
    }

    public String getRoa() {
        return this.stockDetails.getOrDefault("ROA", "");
    }

    public String getRoe() {
        return this.stockDetails.getOrDefault("ROE", "");
    }

    public String getRoi() {
        return this.stockDetails.getOrDefault("ROI", "");
    }

    public String getRsi14() {
        return this.stockDetails.getOrDefault("RSI (14)", "");
    }

    public String getSales() {
        return this.stockDetails.getOrDefault("Sales", "");
    }

    public String getSalesPast5Y() {
        return this.stockDetails.getOrDefault("Sales past 5Y", "");
    }

    public String getSalesQQ() {
        return this.stockDetails.getOrDefault("Sales Q/Q", "");
    }

    public String getSalesSurprise() {
        return this.stockDetails.getOrDefault("Sales Surprise", "");
    }

    public String getSalesYyTtm() {
        return this.stockDetails.getOrDefault("Sales Y/Y TTM", "");
    }

    public String getShortFloat() {
        return this.stockDetails.getOrDefault("Short Float", "");
    }

    public String getShortInterest() {
        return this.stockDetails.getOrDefault("Short Interest", "");
    }

    public String getShortRatio() {
        return this.stockDetails.getOrDefault("Short Ratio", "");
    }

    public String getShsFloat() {
        return this.stockDetails.getOrDefault("Shs Float", "");
    }

    public String getShsOutstand() {
        return this.stockDetails.getOrDefault("Shs Outstand", "");
    }

    public String getSma20() {
        return this.stockDetails.getOrDefault("SMA20", "");
    }

    public String getSma200() {
        return this.stockDetails.getOrDefault("SMA200", "");
    }

    public String getSma50() {
        return this.stockDetails.getOrDefault("SMA50", "");
    }

    public Map<String, String> getStockDetails() {
        return Collections.unmodifiableMap(this.stockDetails);
    }

    /**
     * Get stocks attributes.
     *
     * @return all stock variables as List of Strings
     */
    public List<String> getStringArr() {
        return new ArrayList<>(this.stockDetails.values());
    }

    public String getTargetPrice() {
        return this.stockDetails.getOrDefault("Target Price", "");
    }

    public String getVolatility() {
        return this.stockDetails.getOrDefault("Volatility", "");
    }

    public String getVolume() {
        return this.stockDetails.getOrDefault("Volume", "");
    }

    public String getW52High() {
        return this.stockDetails.getOrDefault("52W High", "");
    }

    public String getW52Low() {
        return this.stockDetails.getOrDefault("52W Low", "");
    }

    public String getCompanyInfo() {
        return companyInfo;
    }
    //</editor-fold>

    private String wrapText(String input) {
        StringBuilder sb = new StringBuilder(input);
        int i = 0;
        while (i + 100 < sb.length() && (i = sb.lastIndexOf(" ", i + 100)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        return sb.toString();
    }

    private Document getStockInfo(String ticker) {
        String url = "https://finviz.com/quote.ashx?t=" + ticker;
        try {
            return Jsoup.connect(url)
                    .get();
        } catch (IOException e) {
            throw new FinvizApiException(e);
        }
    }

    public String getW52Range() {
        return this.stockDetails.getOrDefault("52W Range", "");
    }

    /**
     * Returns a string representation of the Stock object.
     * The string includes all the attributes of the Stock object,
     * formatted as key-value pairs separated by newlines.
     *
     * @return a string representation of the Stock object
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        this.stockDetails.forEach((key, value) -> sb.append("\n")
                .append(key)
                .append(": ")
                .append(value));
        sb.append("\n\nCompany Info: \n")
                .append(this.getCompanyInfo());
        return sb.toString();
    }

}
