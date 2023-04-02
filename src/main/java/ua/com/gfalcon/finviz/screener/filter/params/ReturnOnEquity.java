package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum ReturnOnEquity implements FilterParameter {
    POSITIVE("fa_roe_pos"),
    NEGATIVE("fa_roe_neg"),
    VERY_POSITIVE("fa_roe_verypos"),
    VERY_NEGATIVE("fa_roe_veryneg");

    private final String value;

    ReturnOnEquity(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
