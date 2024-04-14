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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ua.com.gfalcon.finviz.exception.FinvizApiException;

/**
 * The Stocks class represents a collection of stocks.
 * It provides methods to add, retrieve, and check the presence of stocks.
 */
public class Stocks {

    private final List<Stock> stocksList;

    /**
     * Uses a text file with tickers on a new line.
     *
     * @param path text file with stocks
     * @throws FinvizApiException if unable to find ticker
     */
    public Stocks(Path path) {
        stocksList = new ArrayList<>();

        try {
            byte[] bytes = Files.readAllBytes(path);
            String[] input = new String(bytes, StandardCharsets.UTF_8).split("\n");
            for (String s : input) {
                stocksList.add(new Stock(s));
            }
        } catch (IOException e) {
            throw new FinvizApiException(e);
        }

    }

    /**
     * Adds multiple stocks to list.
     * <br>
     * {@code
     * Stocks stocks = new Stocks("MSFT", "AAPL", "TSLA");
     * }
     * <br>
     * To use a text file instead with tickers separated on each line
     * <br>
     * {@code
     * Stocks stocks = new Stocks(new File(System.getProperty("user.home") + "/Desktop/input.txt"));
     * }
     *
     * @param tickers tickers of stocks
     * @throws FinvizApiException finviz cannot find ticker
     */
    public Stocks(String... tickers) {
        stocksList = new ArrayList<>();
        for (String ticker : tickers) {
            stocksList.add(new Stock(ticker));
        }
    }

    /**
     * Get List of Stocks.
     *
     * @return stocks list
     */
    public List<Stock> getStocks() {
        return new ArrayList<>(this.stocksList);
    }

    /**
     * Adds stock to Stocks list.
     *
     * @param stock stock to add
     * @return true if stock is added
     */
    public boolean addStock(Stock stock) {
        if (!stocksList.contains(stock)) {
            this.stocksList.add(stock);
            return true;
        }
        return false;
    }

    /**
     * Adds stock to Stocks list.
     *
     * @param stocks stock to add
     */
    public void addStocks(Stock... stocks) {
        for (Stock stock : stocks) {
            if (!contains(stock)) {
                this.stocksList.add(stock);
            }
        }
    }

    /**
     * Check if Stock is present in received stock list.
     *
     * @param stock stock to check
     * @return true if stock list contains stock
     */
    public boolean contains(Stock stock) {
        return stocksList.contains(stock);
    }

    /**
     * Get stock from stock list by ticker.
     *
     * @param ticker stock to retrieve from Stocks list
     * @return stock that matches param
     */
    public Stock getStock(String ticker) {
        for (Stock stock : stocksList) {
            if (stock.getTicker()
                    .equals(ticker)) {
                return stock;
            }
        }
        return null;
    }
}
