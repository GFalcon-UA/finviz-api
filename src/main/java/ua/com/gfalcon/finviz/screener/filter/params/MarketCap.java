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
 * The MarketCap enum represents the market capitalization filters available for filtering data in the Finviz API.
 * It implements the FilterParameter interface and provides methods to retrieve the value of the filter parameter.
 */
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
