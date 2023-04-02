package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum DividendYield implements FilterParameter {
    NONE("fa_div_none"),
    POSITIVE("fa_div_pos"),
    HIGH("fa_div_high"),
    VERY_HIGH("fa_div_veryhigh"),
    OVER_1_PERCENT("fa_div_o1"),
    OVER_2_PERCENT("fa_div_o2"),
    OVER_3_PERCENT("fa_div_o3"),
    OVER_4_PERCENT("fa_div_o4"),
    OVER_5_PERCENT("fa_div_o5"),
    OVER_6_PERCENT("fa_div_o6"),
    OVER_7_PERCENT("fa_div_o7"),
    OVER_8_PERCENT("fa_div_o8"),
    OVER_9_PERCENT("fa_div_o9"),
    OVER_10_PERCENT("fa_div_o10");

    private final String value;

    DividendYield(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
