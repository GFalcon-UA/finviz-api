package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum EPSgrowthPast5years implements FilterParameter {
    NEGATIVE("fa_eps5years_neg"),
    POSITIVE("fa_eps5years_pos"),
    POSITIVE_LOW("fa_eps5years_poslow"),
    HIGH("fa_eps5years_high"),
    UNDER_5_PERCENT("fa_eps5years_u5"),
    UNDER_10_PERCENT("fa_eps5years_u10"),
    UNDER_15_PERCENT("fa_eps5years_u15"),
    UNDER_20_PERCENT("fa_eps5years_u20"),
    UNDER_25_PERCENT("fa_eps5years_u25"),
    UNDER_30_PERCENT("fa_eps5years_u30"),
    OVER_5_PERCENT("fa_eps5years_o5"),
    OVER_10_PERCENT("fa_eps5years_o10"),
    OVER_15_PERCENT("fa_eps5years_o15"),
    OVER_20_PERCENT("fa_eps5years_o20"),
    OVER_25_PERCENT("fa_eps5years_o25"),
    OVER_30_PERCENT("fa_eps5years_o30");

    private final String value;

    EPSgrowthPast5years(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
