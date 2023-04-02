package ua.com.gfalcon.finviz.screener.filter;

public enum Signal {
    TOP_GAINERS("ta_topgainers"),
    TOP_LOSERS("ta_toplosers"),
    NEW_HIGH("ta_newhigh"),
    NEW_LOW("ta_newlow"),
    MOST_VOLATILE("ta_mostvolatile"),
    MOST_ACTIVE("ta_mostactive"),
    UNUSUAL_VOLUME("ta_unusualvolume");

    private final String value;

    Signal(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
