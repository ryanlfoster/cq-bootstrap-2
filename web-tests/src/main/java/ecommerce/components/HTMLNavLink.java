package ecommerce.components;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;

public class HTMLNavLink {

    private boolean active;
    private String targetHref;
    private String text;

    public HTMLNavLink(Element element ) {

        this.active = Arrays.asList(element.attr("class").split(" ")).contains("active");
        Elements anchor = element.select("a");
        this.targetHref = anchor.get(0).attr("href");
        this.text = anchor.get(0).text();
    }

    public boolean isActive() {
        return active;
    }

    public String getTargetHref() {
        return targetHref;
    }

    public String getText() {
        return text;
    }
}
