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
 * The DebtEquity enum represents different debt-to-equity filter parameters.
 * <p>
 * It implements the FilterParameter interface and provides a method to get the string value of each parameter.
 * The available DebtEquity filter options are HIGH, LOW, UNDER_1, and OVER_1.
 * </p>
 * Usage:
 * DebtEquity filter = DebtEquity.HIGH;
 * String value = filter.getValue(); // returns "fa_debteq_high"
 */
public enum DebtEquity implements FilterParameter {
    HIGH("fa_debteq_high"),
    LOW("fa_debteq_low"),
    UNDER_1("fa_debteq_u1"),
    OVER_1("fa_debteq_o1");

    private final String value;

    DebtEquity(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
