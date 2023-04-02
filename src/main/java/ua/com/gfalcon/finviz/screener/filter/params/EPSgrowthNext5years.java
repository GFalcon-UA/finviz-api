package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum EPSgrowthNext5years implements FilterParameter {
    NEGATIVE("fa_estltgrowth_neg"),
    POSITIVE("fa_estltgrowth_pos"),
    POSITIVE_LOW("fa_estltgrowth_poslow"),
    HIGH("fa_estltgrowth_high"),
    UNDER_5_PERCENT("fa_estltgrowth_u5"),
    UNDER_10_PERCENT("fa_estltgrowth_u10"),
    UNDER_15_PERCENT("fa_estltgrowth_u15"),
    UNDER_20_PERCENT("fa_estltgrowth_u20"),
    UNDER_25_PERCENT("fa_estltgrowth_u25"),
    UNDER_30_PERCENT("fa_estltgrowth_u30"),
    OVER_5_PERCENT("fa_estltgrowth_o5"),
    OVER_10_PERCENT("fa_estltgrowth_o10"),
    OVER_15_PERCENT("fa_estltgrowth_o15"),
    OVER_20_PERCENT("fa_estltgrowth_o20"),
    OVER_25_PERCENT("fa_estltgrowth_o25"),
    OVER_30_PERCENT("fa_estltgrowth_o30");

    private final String value;

    EPSgrowthNext5years(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
