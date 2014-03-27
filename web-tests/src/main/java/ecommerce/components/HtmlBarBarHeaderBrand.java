package ecommerce.components;

import org.jsoup.nodes.Element;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HtmlBarBarHeaderBrand {


    private Element element;

    public HtmlBarBarHeaderBrand(Element element) {
        this.element = element;
    }

    public void assertBrand(String brand) {
        assertThat(element.text(), equalTo(brand));
    }

    public String getText() {
        return element.text();
    }
}
