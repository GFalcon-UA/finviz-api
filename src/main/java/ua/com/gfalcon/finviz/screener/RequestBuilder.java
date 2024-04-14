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

package ua.com.gfalcon.finviz.screener;

import java.util.List;
import java.util.Objects;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.Signal;

/**
 * The RequestBuilder class is responsible for building URL strings with filter parameters and a signal.
 * It provides two methods: build() and build() with a signal.
 */
public class RequestBuilder {

    public static final String SCREENER_URL = "https://finviz.com/screener.ashx?v=411";

    /**
     * Builds a URL string with filter parameters and a signal.
     *
     * @param filters the list of filter parameters
     * @param signal  the signal
     * @return a URL string with filter parameters and a signal
     */
    public String build(List<FilterParameter> filters, Signal signal) {
        StringBuilder builder = new StringBuilder(build(filters));
        if (Objects.nonNull(signal)) {
            builder.append("&s=");
            builder.append(signal.getValue());
        }
        return builder.toString();
    }

    /**
     * Builds a URL string with filter parameters.
     *
     * @param filters the list of filter parameters
     * @return a URL string with filter parameters
     */
    public String build(List<FilterParameter> filters) {
        StringBuilder builder = new StringBuilder(SCREENER_URL);
        if (Objects.nonNull(filters) && !filters.isEmpty()) {
            builder.append("&f=");
            boolean next = false;
            for (FilterParameter parameter : filters) {
                if (next) {
                    builder.append(",");
                }
                builder.append(parameter.getValue());
                next = true;
            }
        }
        return builder.toString();
    }
}
