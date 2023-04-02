package ua.com.gfalcon.finviz.overview;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StocksTest {
    private Stocks stocks;
    private String inputFileTxt = "src/test/resources/input.txt";
    private String outputFileCSV = "target/test-classes/test-results/output.csv";
    private String desktop = System.getProperty("user.home") + "/Desktop";

    @BeforeEach
    void setUp() throws IOException {
        stocks = new Stocks("AAPL", "MSFT", "TSLA");
    }

    @Test
    void testStocks() throws IOException {
        stocks.addStock(new Stock("WMT"));
        stocks.addStocks(new Stock("META"), new Stock("SPY"));
        List<Stock> stocksList = stocks.getStocks();
        stocksList.forEach(stock -> System.out.println(stock.getCompanyName()));
    }

    @Test
    void testStocksWithFile() throws IOException {
        stocks = new Stocks(inputFileTxt);
        StocksUtilities.outputToCSV(stocks, new File(outputFileCSV));
    }

    @Test
    void outputTest() {
        StocksUtilities.outputToCSV(stocks, new File(outputFileCSV));
    }
}
