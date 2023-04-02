package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum GrossMargin implements FilterParameter {
    POSITIVE("fa_grossmargin_pos"),
    NEGATIVE("fa_grossmargin_neg"),
    HIGH("fa_grossmargin_high"),
    OVER_0_PERCENT("fa_grossmargin_o0"),
    OVER_5_PERCENT("fa_grossmargin_o5"),
    OVER_10_PERCENT("fa_grossmargin_o10"),
    OVER_15_PERCENT("fa_grossmargin_o15"),
    OVER_20_PERCENT("fa_grossmargin_o20"),
    OVER_25_PERCENT("fa_grossmargin_o25"),
    OVER_30_PERCENT("fa_grossmargin_o30"),
    OVER_35_PERCENT("fa_grossmargin_o35"),
    OVER_40_PERCENT("fa_grossmargin_o40"),
    OVER_45_PERCENT("fa_grossmargin_o45"),
    OVER_50_PERCENT("fa_grossmargin_o50"),
    OVER_60_PERCENT("fa_grossmargin_o60"),
    OVER_70_PERCENT("fa_grossmargin_o70"),
    OVER_80_PERCENT("fa_grossmargin_o80"),
    OVER_90_PERCENT("fa_grossmargin_o90"),
    UNDER_0_PERCENT("fa_grossmargin_u0"),
    UNDER_5_PERCENT("fa_grossmargin_u5"),
    UNDER_10_PERCENT("fa_grossmargin_u10"),
    UNDER_15_PERCENT("fa_grossmargin_u15"),
    UNDER_20_PERCENT("fa_grossmargin_u20"),
    UNDER_25_PERCENT("fa_grossmargin_u25"),
    UNDER_30_PERCENT("fa_grossmargin_u30"),
    UNDER_35_PERCENT("fa_grossmargin_u35"),
    UNDER_40_PERCENT("fa_grossmargin_u40"),
    UNDER_45_PERCENT("fa_grossmargin_u45"),
    UNDER_50_PERCENT("fa_grossmargin_u50"),
    UNDER_60_PERCENT("fa_grossmargin_u60"),
    UNDER_70_PERCENT("fa_grossmargin_u70"),
    UNDER_80_PERCENT("fa_grossmargin_u80"),
    UNDER_90_PERCENT("fa_grossmargin_u90"),
    UNDER_MINUS_10_PERCENT("fa_grossmargin_u-10"),
    UNDER_MINUS_20_PERCENT("fa_grossmargin_u-20"),
    UNDER_MINUS_30_PERCENT("fa_grossmargin_u-30"),
    UNDER_MINUS_50_PERCENT("fa_grossmargin_u-50"),
    UNDER_MINUS_70_PERCENT("fa_grossmargin_u-70"),
    UNDER_MINUS_100_PERCENT("fa_grossmargin_u-100");

    private final String value;

    GrossMargin(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
