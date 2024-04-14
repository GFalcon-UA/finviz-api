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
 * The CurrentRatio enum represents different current ratio filter parameters.
 * It implements the FilterParameter interface, and provides a method to retrieve the value of each filter parameter.
 */
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
