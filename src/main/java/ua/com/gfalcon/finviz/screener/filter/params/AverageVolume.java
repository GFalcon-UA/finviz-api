package ua.com.gfalcon.finviz.screener.filter.params;

import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

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
