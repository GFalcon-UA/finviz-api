package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum Industry implements FilterParameter {
    STOCK("ind_stocksonly"),
    ETF("ind_exchangetradedfund");

    private final String value;

    Industry(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
