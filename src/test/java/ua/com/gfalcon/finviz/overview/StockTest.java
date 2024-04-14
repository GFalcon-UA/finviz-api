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
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static ua.com.gfalcon.finviz.overview.StocksUtilities.CSV_HEADER;

class StockTest {
    private Stock stock;
    private String outputFileCSV = "target/test-classes/test-results/output.csv";

    @BeforeEach
    void setUp() throws IOException {
        stock = new Stock("MSFT");
    }

    @Test
    void outputTest() {
        StocksUtilities.outputToCSV(stock, new File(outputFileCSV));
    }

    @Test
    void allFieldsArePresentTest() {
        List<String> lostFields = new ArrayList<>();
        String value = null;
        for (String field : CSV_HEADER) {
            value = stock.getStockDetails()
                    .getOrDefault(field, "");
            if (StringUtils.isBlank(value)) {
                lostFields.add(field);
            }
        }
        if (StringUtils.isBlank(stock.getCompanyInfo())) {
            lostFields.add("Company Info");
        }
        Assertions.assertTrue(lostFields.isEmpty(), "The following fields are missing: " + lostFields);
    }

    @Test
    void newFieldsWereAdded() {
        List<String> newFields = new ArrayList<>();
        for (String field : CSV_HEADER) {
            if (!(stock.getStockDetails()
                    .containsKey(field) || "Trades".equals(field))) {
                newFields.add(field);
            }
        }

        Assertions.assertTrue(newFields.isEmpty(), "The following fields were added: " + newFields);
    }

    @Test
    @Disabled("use to load page")
    void saveHtmlPageAsResource() {
        try {
            URL url = new URL("https://finviz.com/quote.ashx?t=MSFT&p=d");
            String date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    .format(LocalDateTime.now());

            try (ReadableByteChannel readableByteChannel = Channels.newChannel(
                    url.openStream()); FileOutputStream fileOutputStream = new FileOutputStream(
                    "src/test/resources/" + date + "-MSFT.html")) {
                fileOutputStream.getChannel()
                        .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Download failed.");
        }
    }
}