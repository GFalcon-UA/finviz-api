package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum CurrentRatio implements FilterParameter {
    HIGH("fa_curratio_high"),
    LOW("fa_curratio_low"),
    UNDER_1("fa_curratio_u1"),
    UNDER_0_5("fa_curratio_u0.5"),
    OVER_0_5("fa_curratio_o0.5"),
    OVER_1("fa_curratio_o1"),
    OVER_1_5("fa_curratio_o1.5"),
    OVER_2("fa_curratio_o2"),
    OVER_3("fa_curratio_o3"),
    OVER_4("fa_curratio_o4"),
    OVER_5("fa_curratio_o5"),
    OVER_10("fa_curratio_o10");

    private final String value;

    CurrentRatio(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
