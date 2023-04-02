package ua.com.gfalcon.finviz.screener;

import java.time.LocalDateTime;
import java.util.Set;

public interface Screener {

    Set<String> getTickers();

    LocalDateTime getResultTimeStamp();

    int getTickersCount();

}
