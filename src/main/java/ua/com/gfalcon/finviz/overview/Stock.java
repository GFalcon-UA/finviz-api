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
import java.util.List;
import java.util.Optional;

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
    private final String index;
    private final String pe;
    private final String eps;
    private final String insiderOwn;
    private final String shsOutstand;
    private final String perfWeek;
    private final String marketCap;
    private final String forwardPE;
    private final String epsNextY;
    private final String insiderTrans;
    private final String shsFloat;
    private final String perfMonth;
    private final String income;
    private final String peg;
    private final String epsNextQ;
    private final String instOwn;
    private final String shortFloat;
    private final String perfQuarter;
    private final String sales;
    private final String ps;
    private final String epsThisYPercent;
    private final String instTrans;
    private final String shortInterest;
    private final String perfHalfY;
    private final String bookSh;
    private final String pb;
    private final String epsNextYPercent;
    private final String roa;
    private final String targetPrice;
    private final String perfYear;
    private final String cashSh;
    private final String pc;
    private final String epsNext5YPercent;
    private final String roe;
    private final String w52Range;
    private final String perfYTD;
    private final String dividend;
    private final String pfcf;
    private final String epsPast5YPercent;
    private final String roi;
    private final String w52High;
    private final String beta;
    private final String dividendPercent;
    private final String quickRatio;
    private final String salesPast5Y;
    private final String grossMargin;
    private final String w52Low;
    private final String atr;
    private final String employees;
    private final String currentRatio;
    private final String salesQQ;
    private final String operMargin;
    private final String rsi14;
    private final String volatility;
    private final String optionable;
    private final String debtEq;
    private final String epsQQ;
    private final String profitMargin;
    private final String relVolume;
    private final String prevClose;
    private final String shortable;
    private final String ltDebtEq;
    private final String earnings;
    private final String payout;
    private final String avgVolume;
    private final String price;
    private final String recom;
    private final String sma20;
    private final String sma50;
    private final String sma200;
    private final String volume;
    private final String change;
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
            this.ticker = Optional.ofNullable(doc.getElementById("ticker"))
                    .orElse(new Element("div"))
                    .text();
            this.companyName = elements.get(0)
                    .text();
            this.sector = elements.get(1)
                    .text();
            this.industry = elements.get(2)
                    .text();
            this.geo = elements.get(3)
                    .text();
            elements = doc.getElementsByClass("snapshot-td2");
            this.index = elements.get(0)
                    .text();
            this.pe = elements.get(1)
                    .text();
            this.eps = elements.get(2)
                    .text();
            this.insiderOwn = elements.get(3)
                    .text();
            this.shsOutstand = elements.get(4)
                    .text();
            this.perfWeek = elements.get(5)
                    .text();
            this.marketCap = elements.get(6)
                    .text();
            this.forwardPE = elements.get(7)
                    .text();
            this.epsNextY = elements.get(8)
                    .text();
            this.insiderTrans = elements.get(9)
                    .text();
            this.shsFloat = elements.get(10)
                    .text();
            this.perfMonth = elements.get(11)
                    .text();
            this.income = elements.get(12)
                    .text();
            this.peg = elements.get(13)
                    .text();
            this.epsNextQ = elements.get(14)
                    .text();
            this.instOwn = elements.get(15)
                    .text();
            this.shortFloat = elements.get(16)
                    .text();
            this.perfQuarter = elements.get(17)
                    .text();
            this.sales = elements.get(18)
                    .text();
            this.ps = elements.get(19)
                    .text();
            this.epsThisYPercent = elements.get(20)
                    .text();
            this.instTrans = elements.get(21)
                    .text();
            this.shortInterest = elements.get(22)
                    .text();
            this.perfHalfY = elements.get(23)
                    .text();
            this.bookSh = elements.get(24)
                    .text();
            this.pb = elements.get(25)
                    .text();
            this.epsNextYPercent = elements.get(26)
                    .text();
            this.roa = elements.get(27)
                    .text();
            this.targetPrice = elements.get(28)
                    .text();
            this.perfYear = elements.get(29)
                    .text();
            this.cashSh = elements.get(30)
                    .text();
            this.pc = elements.get(31)
                    .text();
            this.epsNext5YPercent = elements.get(32)
                    .text();
            this.roe = elements.get(33)
                    .text();
            this.w52Range = elements.get(34)
                    .text();
            this.perfYTD = elements.get(35)
                    .text();
            this.dividend = elements.get(36)
                    .text();
            this.pfcf = elements.get(37)
                    .text();
            this.epsPast5YPercent = elements.get(38)
                    .text();
            this.roi = elements.get(39)
                    .text();
            this.w52High = elements.get(40)
                    .text();
            this.beta = elements.get(41)
                    .text();
            this.dividendPercent = elements.get(42)
                    .text();
            this.quickRatio = elements.get(43)
                    .text();
            this.salesPast5Y = elements.get(44)
                    .text();
            this.grossMargin = elements.get(45)
                    .text();
            this.w52Low = elements.get(46)
                    .text();
            this.atr = elements.get(47)
                    .text();
            this.employees = elements.get(48)
                    .text();
            this.currentRatio = elements.get(49)
                    .text();
            this.salesQQ = elements.get(50)
                    .text();
            this.operMargin = elements.get(51)
                    .text();
            this.rsi14 = elements.get(52)
                    .text();
            this.volatility = elements.get(53)
                    .text();
            this.optionable = elements.get(54)
                    .text();
            this.debtEq = elements.get(55)
                    .text();
            this.epsQQ = elements.get(56)
                    .text();
            this.profitMargin = elements.get(57)
                    .text();
            this.relVolume = elements.get(58)
                    .text();
            this.prevClose = elements.get(59)
                    .text();
            this.shortable = elements.get(60)
                    .text();
            this.ltDebtEq = elements.get(61)
                    .text();
            this.earnings = elements.get(62)
                    .text();
            this.payout = elements.get(63)
                    .text();
            this.avgVolume = elements.get(64)
                    .text();
            this.price = elements.get(65)
                    .text();
            this.recom = elements.get(66)
                    .text();
            this.sma20 = elements.get(67)
                    .text();
            this.sma50 = elements.get(68)
                    .text();
            this.sma200 = elements.get(69)
                    .text();
            this.volume = elements.get(70)
                    .text();
            this.change = elements.get(71)
                    .text();
            this.companyInfo = wrapText(doc.select("td.fullview-profile")
                    .get(0)
                    .text());
        } else {
            throw new FinvizApiException("This ticker " + ticker + " cannot be found");
        }
    }

    //<editor-fold desc="Getters">
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

    public String getIndex() {
        return index;
    }

    public String getPe() {
        return pe;
    }

    public String getEps() {
        return eps;
    }

    public String getInsiderOwn() {
        return insiderOwn;
    }

    public String getShsOutstand() {
        return shsOutstand;
    }

    public String getPerfWeek() {
        return perfWeek;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public String getForwardPE() {
        return forwardPE;
    }

    public String getEpsNextY() {
        return epsNextY;
    }

    public String getInsiderTrans() {
        return insiderTrans;
    }

    public String getShsFloat() {
        return shsFloat;
    }

    public String getPerfMonth() {
        return perfMonth;
    }

    public String getIncome() {
        return income;
    }

    public String getPeg() {
        return peg;
    }

    public String getEpsNextQ() {
        return epsNextQ;
    }

    public String getInstOwn() {
        return instOwn;
    }

    public String getShortFloat() {
        return shortFloat;
    }

    public String getPerfQuarter() {
        return perfQuarter;
    }

    public String getSales() {
        return sales;
    }

    public String getPs() {
        return ps;
    }

    public String getEpsThisYPercent() {
        return epsThisYPercent;
    }

    public String getInstTrans() {
        return instTrans;
    }

    public String getShortInterest() {
        return shortInterest;
    }

    public String getPerfHalfY() {
        return perfHalfY;
    }

    public String getBookSh() {
        return bookSh;
    }

    public String getPb() {
        return pb;
    }

    public String getEpsNextYPercent() {
        return epsNextYPercent;
    }

    public String getRoa() {
        return roa;
    }

    public String getTargetPrice() {
        return targetPrice;
    }

    public String getPerfYear() {
        return perfYear;
    }

    public String getCashSh() {
        return cashSh;
    }

    public String getPc() {
        return pc;
    }

    public String getEpsNext5YPercent() {
        return epsNext5YPercent;
    }

    public String getRoe() {
        return roe;
    }

    public String getW52Range() {
        return w52Range;
    }

    public String getPerfYTD() {
        return perfYTD;
    }

    public String getDividend() {
        return dividend;
    }

    public String getPfcf() {
        return pfcf;
    }

    public String getEpsPast5YPercent() {
        return epsPast5YPercent;
    }

    public String getRoi() {
        return roi;
    }

    public String getW52High() {
        return w52High;
    }

    public String getBeta() {
        return beta;
    }

    public String getDividendPercent() {
        return dividendPercent;
    }

    public String getQuickRatio() {
        return quickRatio;
    }

    public String getSalesPast5Y() {
        return salesPast5Y;
    }

    public String getGrossMargin() {
        return grossMargin;
    }

    public String getW52Low() {
        return w52Low;
    }

    public String getAtr() {
        return atr;
    }

    public String getEmployees() {
        return employees;
    }

    public String getCurrentRatio() {
        return currentRatio;
    }

    public String getSalesQQ() {
        return salesQQ;
    }

    public String getOperMargin() {
        return operMargin;
    }

    public String getRsi14() {
        return rsi14;
    }

    public String getVolatility() {
        return volatility;
    }

    public String getOptionable() {
        return optionable;
    }

    public String getDebtEq() {
        return debtEq;
    }

    public String getEpsQQ() {
        return epsQQ;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public String getRelVolume() {
        return relVolume;
    }

    public String getPrevClose() {
        return prevClose;
    }

    public String getShortable() {
        return shortable;
    }

    public String getLtDebtEq() {
        return ltDebtEq;
    }

    public String getEarnings() {
        return earnings;
    }

    public String getPayout() {
        return payout;
    }

    public String getAvgVolume() {
        return avgVolume;
    }

    public String getPrice() {
        return price;
    }

    public String getRecom() {
        return recom;
    }

    public String getSma20() {
        return sma20;
    }

    public String getSma50() {
        return sma50;
    }

    public String getSma200() {
        return sma200;
    }

    public String getVolume() {
        return volume;
    }

    public String getChange() {
        return change;
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

    /**
     * Get stocks attributes.
     *
     * @return all stock variables as List of Strings
     */
    public List<String> getStringArr() {
        return List.of(this.ticker, this.companyName, this.sector, this.industry, this.geo, this.index, this.pe,
                this.eps, this.insiderOwn, this.shsOutstand, this.perfWeek, this.marketCap, this.forwardPE,
                this.epsNextY, this.insiderTrans, this.shsFloat, this.perfMonth, this.income, this.peg, this.epsNextQ,
                this.instOwn, this.shortFloat, this.perfQuarter, this.sales, this.ps, this.epsThisYPercent,
                this.instTrans, this.shortInterest, this.perfHalfY, this.bookSh, this.pb, this.epsNextYPercent,
                this.roa, this.targetPrice, this.perfYear, this.cashSh, this.pc, this.epsNext5YPercent, this.roe,
                this.w52Range, this.perfYTD, this.dividend, this.pfcf, this.epsPast5YPercent, this.roi, this.w52High,
                this.beta, this.dividendPercent, this.quickRatio, this.salesPast5Y, this.grossMargin, this.w52Low,
                this.atr, this.employees, this.currentRatio, this.salesQQ, this.operMargin, this.rsi14, this.volatility,
                this.optionable, this.debtEq, this.epsQQ, this.profitMargin, this.relVolume, this.prevClose,
                this.shortable, this.ltDebtEq, this.earnings, this.payout, this.avgVolume, this.price, this.recom,
                this.sma20, this.sma50, this.sma200, this.volume, this.change);
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
        return "\nTicker: " + ticker + "\nCompany Name: " + companyName + "\nSector: " + sector + "\nIndustry: "
                + industry + "\nGeo: " + geo + "\nIndex: " + index + "\nP/E: " + pe + "\nEPS: " + eps
                + "\nInsider Ownership: " + insiderOwn + "\nShares Outstanding: " + shsOutstand + "\nPerf Week: "
                + perfWeek + "\nMarket Cap: " + marketCap + "\nForward P/E: " + forwardPE + "\nEPS Next Y: " + epsNextY
                + "\nInsider Trans: " + insiderTrans + "\nShares Float: " + shsFloat + "\nPerf Month: " + perfMonth
                + "\nIncome: " + income + "\nPEG: " + peg + "\nEPS Next Quarter: " + epsNextQ
                + "\nInstitutional Ownership: " + instOwn + "\nShort Float: " + shortFloat + "\nPerf Quarter: "
                + perfQuarter + "\nSales: " + sales + "\nP/S: " + ps + "\nEPS This Year %: " + epsThisYPercent
                + "\nInstitutional Trans: " + instTrans + "\nShort Interest: " + shortInterest + "\nPerf Half Y: "
                + perfHalfY + "\nBook/Share: " + bookSh + "\nP/B: " + pb + "\nEPS Next Y %: " + epsNextYPercent
                + "\nROA: " + roa + "\nTarget Price: " + targetPrice + "\nPerf Year: " + perfYear + "\nCash/Share: "
                + cashSh + "\nP/C: " + pc + "\nEPS Next 5 Year %: " + epsNext5YPercent + "\nROE: " + roe
                + "\n52 Week Range: " + w52Range + "\nPerf YTD: " + perfYTD + "\nDividend: " + dividend + "\nP/FCF: "
                + pfcf + "\nEPS Past 5 Y %: " + epsPast5YPercent + "\nROI: " + roi + "\n52 Week High: " + w52High
                + "\nBeta: " + beta + "\nDividend %: " + dividendPercent + "\nQuick Ratio: " + quickRatio
                + "\nSales Past 5 Y: " + salesPast5Y + "\nGross Margin: " + grossMargin + "\n52 Week Low: " + w52Low
                + "\nATR (14): " + atr + "\nEmployees: " + employees + "\nCurrent Ratio: " + currentRatio
                + "\nSales Q/Q: " + salesQQ + "\nOperating Margin: " + operMargin + "\nRSI (14): " + rsi14
                + "\nVolatility: " + volatility + "\nOptionable: " + optionable + "\nDebt/Eq: " + debtEq + "\nEPS Q/Q: "
                + epsQQ + "\nProfit Margin: " + profitMargin + "\nRel Volume: " + relVolume + "\nPrevious Close: "
                + prevClose + "\nShortable: " + shortable + "\nLT Debt/Eq: " + ltDebtEq + "\nEarnings: " + earnings
                + "\nPayout: " + payout + "\nAvg Volume: " + avgVolume + "\nPrice: " + price + "\nRecome: " + recom
                + "\nSMA20: " + sma20 + "\nSMA50: " + sma50 + "\nSMA200: " + sma200 + "\nVolume: " + volume
                + "\nChange: " + change + "\n\nCompany Info: \n" + companyInfo;
    }

}
