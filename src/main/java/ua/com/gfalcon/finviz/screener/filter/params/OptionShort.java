package ua.com.gfalcon.finviz.screener.filter.params;


import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

public enum OptionShort implements FilterParameter {
    OPTIONABLE("sh_opt_option"),
    SHORTABLE("sh_opt_short"),
    OPTIONABLE_AND_SHORTABLE("sh_opt_optionshort");

    private final String value;

    OptionShort(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
