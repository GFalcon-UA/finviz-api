package ua.com.gfalcon.finviz.validator;

import java.util.List;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public class ScreenerFilterValidator implements Validator<List<FilterParameter>> {

    private ScreenerFilterValidator() {

    }

    public static ScreenerFilterValidator getInstance() {
        return new ScreenerFilterValidator();
    }

    @Override
    public boolean isValid(List<FilterParameter> obj) {
        return obj != null && obj.stream().map(o -> o.getClass().getName()).distinct().count() == obj.size();
    }
}
