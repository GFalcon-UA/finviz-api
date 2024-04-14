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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import ua.com.gfalcon.finviz.exception.FinvizApiException;

/**
 * The StocksUtilities class provides utility methods for working with Stocks objects.
 */
public class StocksUtilities {

    private static final Logger LOG = LoggerFactory.getLogger(StocksUtilities.class);

    private static final String CONSOLE_CREATE_OUTPUT_MSG = "Unable to create required directories for output file.";
    static final String[] CSV_HEADER = {"Ticker", "Company name", "Sector", "Industry", "Geo", "Index", "P/E", "EPS (ttm)", "Insider Own", "Shs Outstand", "Perf Week", "Market Cap", "Forward P/E", "EPS next Y", "Insider Trans", "Shs Float", "Perf Month", "Income", "PEG", "EPS next Q", "Inst Own", "Short Float", "Perf Quarter", "Sales", "P/S", "EPS this Y", "Inst Trans", "Short Ratio", "Perf Half Y", "Book/sh", "P/B", "ROA", "Short Interest", "Perf Year", "Cash/sh", "P/C", "EPS next 5Y", "ROE", "52W Range", "Perf YTD", "Dividend Est.", "P/FCF", "EPS past 5Y", "ROI", "52W High", "Beta", "Dividend TTM", "Quick Ratio", "Sales past 5Y", "Gross Margin", "52W Low", "ATR (14)", "Dividend Ex-Date", "Current Ratio", "EPS Y/Y TTM", "Oper. Margin", "RSI (14)", "Volatility", "Employees", "Debt/Eq", "Sales Y/Y TTM", "Profit Margin", "Recom", "Target Price", "Option/Short", "LT Debt/Eq", "EPS Q/Q", "Payout", "Rel Volume", "Prev Close", "Sales Surprise", "EPS Surprise", "Sales Q/Q", "Earnings", "Avg Volume", "Price", "SMA20", "SMA50", "SMA200", "Trades", "Volume", "Change"};

    private StocksUtilities() {
        // nothing
    }

    /**
     * Outputs Stocks to CSV file.
     * Ex:
     * {@code
     * Export.outputToCSV(stocks, System.getProperty("user.home") + "/Desktop/output.csv");
     * }
     *
     * @param stocks Stocks to output
     * @param file   Absolute file path of CSV file
     */
    public static void outputToCSV(Stocks stocks, File file) {
        if (file.getParentFile()
                .mkdirs()) {
            try {
                FileWriter outputFile;
                CSVWriter writer;
                // If file exists already, we append the data
                if (file.exists()) {
                    outputFile = new FileWriter(file, StandardCharsets.UTF_8, true);
                    FileReader readFile = new FileReader(file, StandardCharsets.UTF_8);
                    CSVReader reader = new CSVReader(readFile);
                    writer = new CSVWriter(outputFile);
                    // If file exist but is empty, we add the header first
                    if (reader.readNext().length == 0) {
                        writer.writeNext(CSV_HEADER);
                    }
                    readFile.close();
                    reader.close();
                } else {
                    outputFile = new FileWriter(file, StandardCharsets.UTF_8);

                    writer = new CSVWriter(outputFile);
                    writer.writeNext(CSV_HEADER);
                }
                for (Stock stock : stocks.getStocks()) {
                    writer.writeNext(stock.getStringArr()
                            .toArray(new String[0]));
                }
                writer.close();
                outputFile.close();
            } catch (IOException | CsvValidationException e) {
                throw new FinvizApiException(e);
            }
        } else {
            LOG.info(CONSOLE_CREATE_OUTPUT_MSG);
        }
    }

    /**
     * Outputs Stock to CSV file.
     * Ex:
     * {@code
     * Export.outputToCSV(stocks, System.getProperty("user.home") + "/Desktop/output.csv");
     * }
     *
     * @param stock Stock to output
     * @param file  Absolute file path of CSV file
     */
    public static void outputToCSV(Stock stock, File file) {
        if (file.getParentFile()
                .mkdirs()) {
            try {
                FileWriter outputFile;
                CSVWriter writer;
                // If file exists already, we append the data
                if (file.exists()) {
                    outputFile = new FileWriter(file, StandardCharsets.UTF_8, true);
                    FileReader readFile = new FileReader(file, StandardCharsets.UTF_8);
                    CSVReader reader = new CSVReader(readFile);
                    writer = new CSVWriter(outputFile);
                    // If file exist but is empty, we add the header first
                    if (reader.readNext().length == 0) {
                        writer.writeNext(CSV_HEADER);
                    }
                    readFile.close();
                    reader.close();
                } else {
                    outputFile = new FileWriter(file, StandardCharsets.UTF_8);
                    writer = new CSVWriter(outputFile);
                    writer.writeNext(CSV_HEADER);
                }
                writer.writeNext(stock.getStringArr()
                        .toArray(new String[0]));
                writer.close();
                outputFile.close();
            } catch (IOException | CsvValidationException e) {
                throw new FinvizApiException(e);
            }
        } else {
            LOG.info(CONSOLE_CREATE_OUTPUT_MSG);
        }
    }

}
