package ua.com.gfalcon.finviz.overview;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockTest {
    private Stock stock;
    private String outputFileCSV = "target/test-classes/test-results/output.csv";

    @BeforeEach
    void setUp() throws IOException {
        stock = new Stock("MSFT");
    }

    @Test
    void testStock() {
        stock.getStringArr(); // Returns all data as string array. Useful for exporting
        System.out.println("Stock Price: " + stock.getPrice() + "\n" + // Stock price
                "Stock Dividend: " + stock.getDividend() + "\n" + // Stock dividend yield
                "\nStock String Output: " + stock.toString()); // Outputs all data as string
    }

    @Test
    void outputTest() {
        StocksUtilities.outputToCSV(stock, outputFileCSV);
    }
}