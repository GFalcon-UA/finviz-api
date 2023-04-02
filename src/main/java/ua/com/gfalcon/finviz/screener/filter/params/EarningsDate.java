package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum EarningsDate implements FilterParameter {
    TODAY("earningsdate_today"),
    TODAY_BEFORE_MARKET_OPEN("earningsdate_todaybefore"),
    TODAY_AFTER_MARKET_CLOSE("earningsdate_todayafter"),
    TOMORROW("earningsdate_tomorrow"),
    TOMORROW_BEFORE_MARKET_OPEN("earningsdate_tomorrowbefore"),
    TOMORROW_AFTER_MARKET_CLOSE("earningsdate_tomorrowafter"),
    YESTERDAY("earningsdate_yesterday"),
    YESTERDAY_BEFORE_MARKET_OPEN("earningsdate_yesterdaybefore"),
    YESTERDAY_AFTER_MARKET_CLOSE("earningsdate_yesterdayafter"),
    NEXT_5_DAYS("earningsdate_nextdays5"),
    PREVIOUS_5_DAYS("earningsdate_prevdays5"),
    THIS_WEEK("earningsdate_thisweek"),
    NEXT_WEEK("earningsdate_nextweek"),
    PREVIOUS_WEEK("earningsdate_prevweek"),
    THIS_MONTH("earningsdate_thismonth");

    private final String value;

    EarningsDate(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
