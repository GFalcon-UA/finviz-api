package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum MarketCap implements FilterParameter {
    NANO("cap_nano"),
    MICRO("cap_micro"),
    SMALL("cap_small"),
    MID("cap_mid"),
    LARGE("cap_large"),
    MEGA("cap_mega"),
    MICRO_PLUS("cap_microover"),
    SMALL_PLUS("cap_smallover"),
    MID_PLUS("cap_midover"),
    LARGE_PLUS("cap_largeover");

    private final String value;

    MarketCap(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
