package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum Price implements FilterParameter {
    FROM_1_TO_5("sh_price_1to5"),
    FROM_1_TO_10("sh_price_1to10"),
    FROM_1_TO_20("sh_price_1to20"),
    FROM_5_TO_10("sh_price_5to10"),
    FROM_5_TO_20("sh_price_5to20"),
    FROM_5_TO_50("sh_price_5to50"),
    FROM_10_TO_20("sh_price_10to20"),
    FROM_10_TO_50("sh_price_10to50"),
    FROM_20_TO_50("sh_price_20to50"),
    FROM_50_TO_100("sh_price_50to100");

    private final String value;

    Price(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
