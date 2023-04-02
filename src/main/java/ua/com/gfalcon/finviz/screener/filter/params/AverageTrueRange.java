package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum AverageTrueRange implements FilterParameter {
    OVER_0_25("ta_averagetruerange_o0.25"),
    OVER_0_5("ta_averagetruerange_o0.5"),
    OVER_0_75("ta_averagetruerange_o0.75"),
    OVER_1("ta_averagetruerange_o1"),
    OVER_1_5("ta_averagetruerange_o1.5"),
    OVER_2("ta_averagetruerange_o2"),
    OVER_2_5("ta_averagetruerange_o2.5"),
    OVER_3("ta_averagetruerange_o3"),
    OVER_3_5("ta_averagetruerange_o3.5"),
    OVER_4("ta_averagetruerange_o4"),
    OVER_4_5("ta_averagetruerange_o4.5"),
    OVER_5("ta_averagetruerange_o5"),
    UNDER_0_25("ta_averagetruerange_u0.25"),
    UNDER_0_5("ta_averagetruerange_u0.5"),
    UNDER_0_75("ta_averagetruerange_u0.75"),
    UNDER_1("ta_averagetruerange_u1"),
    UNDER_1_5("ta_averagetruerange_u1.5"),
    UNDER_2("ta_averagetruerange_u2"),
    UNDER_2_5("ta_averagetruerange_u2.5"),
    UNDER_3("ta_averagetruerange_u3"),
    UNDER_3_5("ta_averagetruerange_u3.5"),
    UNDER_4("ta_averagetruerange_u4"),
    UNDER_4_5("ta_averagetruerange_u4.5"),
    UNDER_5("ta_averagetruerange_u5");

    private final String value;

    AverageTrueRange(String val) {
        this.value = val;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
