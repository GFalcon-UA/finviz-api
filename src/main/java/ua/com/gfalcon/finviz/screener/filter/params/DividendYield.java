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
 * Represents the different options for filtering by dividend yield.
 */
public enum DividendYield implements FilterParameter {
    NONE("fa_div_none"),
    POSITIVE("fa_div_pos"),
    HIGH("fa_div_high"),
    VERY_HIGH("fa_div_veryhigh"),
    OVER_1_PERCENT("fa_div_o1"),
    OVER_2_PERCENT("fa_div_o2"),
    OVER_3_PERCENT("fa_div_o3"),
    OVER_4_PERCENT("fa_div_o4"),
    OVER_5_PERCENT("fa_div_o5"),
    OVER_6_PERCENT("fa_div_o6"),
    OVER_7_PERCENT("fa_div_o7"),
    OVER_8_PERCENT("fa_div_o8"),
    OVER_9_PERCENT("fa_div_o9"),
    OVER_10_PERCENT("fa_div_o10");

    private final String value;

    DividendYield(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
