package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum PayoutRatio implements FilterParameter {
    NONE("fa_payoutratio_none"),
    POSITIVE("fa_payoutratio_pos"),
    LOW("fa_payoutratio_low"),
    HIGH("fa_payoutratio_high");

    private final String value;

    PayoutRatio(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
