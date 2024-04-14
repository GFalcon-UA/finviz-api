/*
 *  MIT License
 * -----------
 *
 * Copyright (c) 2016-2024 Oleksii V. KHALIKOV (http://gfalcon.com.ua)
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

/**
 * This enum represents different earnings date filter parameters that can be used
 * in the application. It implements the FilterParameter interface.
 * <br>
 * Earnings dates can be filtered based on different time periods such as today,
 * tomorrow, yesterday, next 5 days, previous 5 days, this week, next week, previous week,
 * and this month.
 */
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
