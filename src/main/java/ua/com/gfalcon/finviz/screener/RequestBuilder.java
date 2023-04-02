package ua.com.gfalcon.finviz.screener;

import java.util.List;
import java.util.Objects;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.Signal;

public class RequestBuilder {

    public String build(List<FilterParameter> filters) {
        StringBuilder builder = new StringBuilder("https://finviz.com/screener.ashx?v=411");
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

    public String build(List<FilterParameter> filters, Signal signal) {
        StringBuilder builder = new StringBuilder(build(filters));
        if (Objects.nonNull(signal)) {
            builder.append("&s=");
            builder.append(signal.getValue());
        }
        return builder.toString();
    }
}
