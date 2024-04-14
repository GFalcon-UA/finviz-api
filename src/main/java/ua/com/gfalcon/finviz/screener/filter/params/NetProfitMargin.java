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
 * The NetProfitMargin class is an enumeration that represents different net profit margin filters.
 * It implements the FilterParameter interface, which provides a method to retrieve the value of the filter parameter.
 */
public enum NetProfitMargin implements FilterParameter {
    POSITIVE("fa_netmargin_pos"),
    NEGATIVE("fa_netmargin_neg"),
    VERY_NEGATIVE("fa_netmargin_veryneg"),
    HIGH("fa_netmargin_high"),
    UNDER_90_PERCENT("fa_netmargin_u90"),
    UNDER_80_PERCENT("fa_netmargin_u80"),
    UNDER_70_PERCENT("fa_netmargin_u70"),
    UNDER_60_PERCENT("fa_netmargin_u60"),
    UNDER_50_PERCENT("fa_netmargin_u50"),
    UNDER_45_PERCENT("fa_netmargin_u45"),
    UNDER_40_PERCENT("fa_netmargin_u40"),
    UNDER_35_PERCENT("fa_netmargin_u35"),
    UNDER_30_PERCENT("fa_netmargin_u30"),
    UNDER_25_PERCENT("fa_netmargin_u25"),
    UNDER_20_PERCENT("fa_netmargin_u20"),
    UNDER_15_PERCENT("fa_netmargin_u15"),
    UNDER_10_PERCENT("fa_netmargin_u10"),
    UNDER_5_PERCENT("fa_netmargin_u5"),
    UNDER_0_PERCENT("fa_netmargin_u0"),
    UNDER_MINUS_10_PERCENT("fa_netmargin_u-10"),
    UNDER_MINUS_20_PERCENT("fa_netmargin_u-20"),
    UNDER_MINUS_30_PERCENT("fa_netmargin_u-30"),
    UNDER_MINUS_50_PERCENT("fa_netmargin_u-50"),
    UNDER_MINUS_70_PERCENT("fa_netmargin_u-70"),
    UNDER_MINUS_100_PERCENT("fa_netmargin_u-100"),
    OVER_0_PERCENT("fa_netmargin_o0"),
    OVER_5_PERCENT("fa_netmargin_o5"),
    OVER_10_PERCENT("fa_netmargin_o10"),
    OVER_15_PERCENT("fa_netmargin_o15"),
    OVER_20_PERCENT("fa_netmargin_o20"),
    OVER_25_PERCENT("fa_netmargin_o25"),
    OVER_30_PERCENT("fa_netmargin_o30"),
    OVER_35_PERCENT("fa_netmargin_o35"),
    OVER_40_PERCENT("fa_netmargin_o40"),
    OVER_45_PERCENT("fa_netmargin_o45"),
    OVER_50_PERCENT("fa_netmargin_o50"),
    OVER_60_PERCENT("fa_netmargin_o60"),
    OVER_70_PERCENT("fa_netmargin_o70"),
    OVER_80_PERCENT("fa_netmargin_o80"),
    OVER_90_PERCENT("fa_netmargin_o90");

    private final String value;

    NetProfitMargin(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
