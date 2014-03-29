package ecommerce.components;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class HTMLNavBarLinks {

    private final List<HTMLNavLink> links;

    public HTMLNavBarLinks(Element root) {
        links = new ArrayList<HTMLNavLink>();
        Elements lis = root.select("li");
        for (Element link : lis) {
            this.links.add(new HTMLNavLink(link));
        }
    }

    public int size(){
        return links.size();
    }

    public List<HTMLNavLink> getLinks(){
        return links;
    }
}
