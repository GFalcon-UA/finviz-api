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
 * Enumeration class representing different types of filters for EPS growth
 * next 5 years.
 *
 * <p>The EPSgrowthNext5years class implements the FilterParameter interface
 * and provides filter options for EPS growth next 5 years. Each option has a
 * corresponding string value that can be used for filtering.</p>
 */
public enum EPSgrowthNext5years implements FilterParameter {
    NEGATIVE("fa_estltgrowth_neg"),
    POSITIVE("fa_estltgrowth_pos"),
    POSITIVE_LOW("fa_estltgrowth_poslow"),
    HIGH("fa_estltgrowth_high"),
    UNDER_5_PERCENT("fa_estltgrowth_u5"),
    UNDER_10_PERCENT("fa_estltgrowth_u10"),
    UNDER_15_PERCENT("fa_estltgrowth_u15"),
    UNDER_20_PERCENT("fa_estltgrowth_u20"),
    UNDER_25_PERCENT("fa_estltgrowth_u25"),
    UNDER_30_PERCENT("fa_estltgrowth_u30"),
    OVER_5_PERCENT("fa_estltgrowth_o5"),
    OVER_10_PERCENT("fa_estltgrowth_o10"),
    OVER_15_PERCENT("fa_estltgrowth_o15"),
    OVER_20_PERCENT("fa_estltgrowth_o20"),
    OVER_25_PERCENT("fa_estltgrowth_o25"),
    OVER_30_PERCENT("fa_estltgrowth_o30");

    private final String value;

    EPSgrowthNext5years(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
