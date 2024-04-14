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
 * An enumeration representing various average volume filter parameters.
 */
public enum AverageVolume implements FilterParameter {
    UNDER_50_K("sh_avgvol_u50"),
    UNDER_100_K("sh_avgvol_u100"),
    UNDER_500_K("sh_avgvol_u500"),
    UNDER_750_K("sh_avgvol_u750"),
    UNDER_1_M("sh_avgvol_u1000"),
    OVER_50_K("sh_avgvol_o50"),
    OVER_100_K("sh_avgvol_o100"),
    OVER_200_K("sh_avgvol_o200"),
    OVER_300_K("sh_avgvol_o300"),
    OVER_400_K("sh_avgvol_o400"),
    OVER_500_K("sh_avgvol_o500"),
    OVER_750_K("sh_avgvol_o750"),
    OVER_1_M("sh_avgvol_o1000"),
    OVER_2_M("sh_avgvol_o2000"),
    FROM_100K_TO_500K("sh_avgvol_100to500"),
    FROM_100K_TO_1M("sh_avgvol_100to1000"),
    FROM_500K_TO_1M("sh_avgvol_500to1000"),
    FROM_500K_TO_10M("sh_avgvol_500to10000");

    private final String value;

    AverageVolume(String value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return this.value;
    }
}
