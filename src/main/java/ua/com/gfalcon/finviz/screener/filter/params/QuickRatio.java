package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum QuickRatio implements FilterParameter {
    HIGH("fa_quickratio_high"),
    LOW("fa_quickratio_low");

    private final String value;

    QuickRatio(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
