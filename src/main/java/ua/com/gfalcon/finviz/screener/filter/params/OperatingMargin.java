package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum OperatingMargin implements FilterParameter {
    POSITIVE("fa_opermargin_pos"),
    NEGATIVE("fa_opermargin_neg"),
    VERY_NEGATIVE("fa_opermargin_veryneg"),
    HIGH("fa_opermargin_high");

    private final String value;

    OperatingMargin(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
