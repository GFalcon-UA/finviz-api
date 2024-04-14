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
 * The Price enum represents the price range options for filtering data.
 * Each price range has a corresponding value used for filtering.
 * Price ranges are defined as constants and can be retrieved using getValue() method.
 */
public enum Price implements FilterParameter {
    FROM_1_TO_5("sh_price_1to5"),
    FROM_1_TO_10("sh_price_1to10"),
    FROM_1_TO_20("sh_price_1to20"),
    FROM_5_TO_10("sh_price_5to10"),
    FROM_5_TO_20("sh_price_5to20"),
    FROM_5_TO_50("sh_price_5to50"),
    FROM_10_TO_20("sh_price_10to20"),
    FROM_10_TO_50("sh_price_10to50"),
    FROM_20_TO_50("sh_price_20to50"),
    FROM_50_TO_100("sh_price_50to100");

    private final String value;

    Price(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
