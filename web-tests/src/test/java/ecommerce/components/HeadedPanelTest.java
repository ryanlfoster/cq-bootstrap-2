package ecommerce.components;

import org.jsoup.nodes.Document;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class HeadedPanelTest extends AbstractViewTest {


    @Test @Ignore("this page uses javascript now for the html")
    public void panelShouldBeRenderedWithDefaultText() throws Exception {
        final Document document =getDocument();
//        HeadedPanel panel = new HeadedPanel(new HtmlHeadedPanelModel(document.getElementById("panel_2")));
        System.out.println(document.html());
//        assertThat(panel.getModel().getHeaderText(), equalTo(FakeHeadedPanelSupportTag.HEADER_TEXT));
//        assertThat(panel.getModel().getText(), equalTo(FakeHeadedPanelSupportTag.TEXT));
    }

    public String getPage() {
        return "content/ecommerce/en.jsp";
    }
}
