package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum Exchange implements FilterParameter {
    AMEX("exch_amex"),
    NASDAQ("exch_nasd"),
    NYSE("exch_nyse");

    private final String value;

    Exchange(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
