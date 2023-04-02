package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum DebtEquity implements FilterParameter {
    HIGH("fa_debteq_high"),
    LOW("fa_debteq_low"),
    UNDER_1("fa_debteq_u1"),
    OVER_1("fa_debteq_o1");

    private final String value;

    DebtEquity(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
