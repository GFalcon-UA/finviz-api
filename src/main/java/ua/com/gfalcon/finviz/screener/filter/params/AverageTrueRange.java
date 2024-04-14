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
 * Represents different levels for the Average True Range filter.
 */
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
