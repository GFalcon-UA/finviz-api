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
 * The IPOdate enum represents various IPO date filter parameters.
 */
public enum IPOdate implements FilterParameter {
    YEAR_AGO("ipodate_more1"),
    MORE_THAN_5_YEARS_AGO("ipodate_more5"),
    MORE_THAN_10_YEARS_AGO("ipodate_more10"),
    MORE_THAN_15_YEARS_AGO("ipodate_more15"),
    MORE_THAN_20_YEARS_AGO("ipodate_more20"),
    MORE_THAN_25_YEARS_AGO("ipodate_more25");

    private final String value;

    IPOdate(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
