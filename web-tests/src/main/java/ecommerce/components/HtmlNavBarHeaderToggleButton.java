package ecommerce.components;

import org.jsoup.nodes.Element;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

class HtmlNavBarHeaderToggleButton {

    private Element root;

    public HtmlNavBarHeaderToggleButton(Element element) {

        root = element;
    }

    public void assertValidStructure() {
        assertThat(root.select("span.icon-bar").size(), equalTo(3));
        assertThat(root.select("span.sr-only").size(), equalTo(1));
    }

    public HtmlNavBarCollapseTarget getCollapseTarget() {
        return new HtmlNavBarCollapseTarget(root.attr("data-target"));
    }

    public String getTargetId() {
        return root.attr("data-target").replaceFirst("#", "");
    }
}
