package ua.com.gfalcon.finviz.screener;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.htmlunit.WebClient;
import org.htmlunit.html.DomNode;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.html.HtmlSpan;
import org.htmlunit.html.HtmlTable;

import ua.com.gfalcon.finviz.exception.FinvizApiException;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.Signal;

public class FinvizScreener implements Screener {

    private List<FilterParameter> parameters;
    private Signal signal;

    public FinvizScreener(List<FilterParameter> parameters, Signal signal) {
        this.parameters = parameters;
        this.signal = signal;
    }

    public Set<String> getTickers() {
        Set<String> tickers = new HashSet<>();
        int count = 0;
        try(final WebClient client = new WebClient()) {
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);
            RequestBuilder builder = new RequestBuilder();
//
            String url = builder.build(this.parameters, this.signal);
            HtmlPage page = client.getPage(url);
            HtmlTable table = (HtmlTable) page.getElementById("screener-views-table");
            count = table.getElementsByTagName("td")
                    .stream()
                    .filter(htmlElement -> htmlElement.getAttribute("class")
                            .equals("count-text"))
                    .map((Function<DomNode, String>) DomNode::getVisibleText)
                    .filter(s -> s.contains("Total:") && s.contains("#"))
                    .map(s -> s.split("#")[0])
                    .map(s -> Integer.parseInt(s.substring("Total:".length()).trim()))
                    .findFirst().orElse(-1);

            boolean nextLoad = false;
            for (int i = 1; i < count; i = i + 1000) {
                if (nextLoad) {
                    String newUrl = url + "&r=" + i;
                    page = client.getPage(newUrl);
                    table = (HtmlTable) page.getElementById("screener-views-table");
                }
                tickers.addAll(
                        table.getElementsByTagName("td")
                                .stream()
                                .filter(htmlElement -> htmlElement.getAttribute("class")
                                        .equals("screener-tickers"))
                                .flatMap((Function<HtmlElement, Stream<DomNode>>) htmlElement -> htmlElement.getChildNodes()
                                        .stream())
                                .filter(HtmlSpan.class::isInstance)
                                .map(DomNode::getVisibleText)
                                .map(String::trim)
                                .collect(Collectors.toList())
                );
                nextLoad = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count < 0) {
            throw new FinvizApiException("The count is not recognized");
        }
        if(tickers.size() != count) {
            throw new FinvizApiException("Count mismatched");
        }
        return tickers;
    }
}
