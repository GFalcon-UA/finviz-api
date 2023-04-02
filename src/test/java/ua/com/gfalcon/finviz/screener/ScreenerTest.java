package ua.com.gfalcon.finviz.screener;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
    void getTickers() {
        Screener screener = new FinvizScreener(tradingStocks(), Signal.TOP_GAINERS);

        Set<String> tickers = screener.getTickers();

        assertNotNull(screener.getResultTimeStamp());
    }

    @Test
    void noDuplicatesInFilterParameters() {
        Exception exception = assertThrows(FinvizApiException.class, () -> {
            new FinvizScreener(List.of(
                    Industry.STOCK, Industry.ETF
            ), Signal.NEW_LOW);
        });

        String expectedMessage = "Incorrect list of parameters: [STOCK, ETF]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public static List<FilterParameter> tradingStocks() {
        return List.of(
                MarketCap.SMALL_PLUS,
                Industry.STOCK,
                OptionShort.SHORTABLE,
                AverageVolume.OVER_500_K,
                IPOdate.MORE_THAN_5_YEARS_AGO//,
//                Price.FROM_1_TO_20
        );
    }
}