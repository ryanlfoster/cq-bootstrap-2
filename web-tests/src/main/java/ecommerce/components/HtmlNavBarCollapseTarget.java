package ecommerce.components;

public class HtmlNavBarCollapseTarget {


    private String attr;

    public HtmlNavBarCollapseTarget(String attr) {
        this.attr = attr;
    }

    String getTargetId() {
        return attr;
    }
}
