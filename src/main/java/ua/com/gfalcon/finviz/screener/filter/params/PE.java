package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum PE implements FilterParameter {
    LOW("fa_pe_low"),
    PROFITABLE("fa_pe_profitable"),
    HIGH("fa_pe_high");

    private final String value;

    PE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
