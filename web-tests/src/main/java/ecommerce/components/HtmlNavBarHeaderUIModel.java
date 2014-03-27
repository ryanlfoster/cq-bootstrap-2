package ecommerce.components;

import ecommerce.domain.NavBarHeaderUI;
import org.jsoup.nodes.Element;

public class HtmlNavBarHeaderUIModel implements NavBarHeaderUI {

    Element root;
    Element header;

    HtmlNavBarHeaderUIModel(Element root) {
        this.root = root;
        header = root.select(".navbar-header").get(0);
    }

    public HtmlNavBarHeaderToggleButton getToogleButton() {
        return new HtmlNavBarHeaderToggleButton(header.select("button.navbar-toggle").get(0));
    }

    public HtmlBarBarHeaderBrand getBrandHtml() {
        return new HtmlBarBarHeaderBrand(header.select(".navbar-brand").get(0));
    }

    @Override
    public String getBrand() {
        return getBrandHtml().getText();
    }

    public Element select(HtmlNavBarCollapseTarget collapseTarget) {
        return root.getElementById(collapseTarget.getTargetId().replaceAll("#" ,""));
    }


    public HTMLNavBarLinks getLinks(){
        return new HTMLNavBarLinks(root.getElementById(getToogleButton().getTargetId()));
    }
}
