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
 * ReturnOnEquity is an enumeration that represents different filter parameters for return on equity.
 * It implements the FilterParameter interface.
 * <p>
 * The possible return on equity filter parameters are:<br>
 * - POSITIVE: Represents the filter parameter for positive return on equity.<br>
 * - NEGATIVE: Represents the filter parameter for negative return on equity.<br>
 * - VERY_POSITIVE: Represents the filter parameter for very positive return on equity.<br>
 * - VERY_NEGATIVE: Represents the filter parameter for very negative return on equity.<br>
 * </p>
 * Each filter parameter has a corresponding value that can be retrieved using the getValue() method.
 */
public enum ReturnOnEquity implements FilterParameter {
    POSITIVE("fa_roe_pos"),
    NEGATIVE("fa_roe_neg"),
    VERY_POSITIVE("fa_roe_verypos"),
    VERY_NEGATIVE("fa_roe_veryneg");

    private final String value;

    ReturnOnEquity(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
