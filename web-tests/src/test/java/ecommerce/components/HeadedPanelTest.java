package ecommerce.components;

import ecommerce.domain.HeadedPanel;
import ecommerce.fake.FakeHeadedPanelSupportTag;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HeadedPanelTest extends AbstractViewTest {


    @Test
    public void panelShouldBeRenderedWithDefaultText() throws Exception {
        final Document document =getDocument();
        HeadedPanel panel = new HeadedPanel(new HtmlHeadedPanelModel(document.getElementById("panel_2")));
        assertThat(panel.getModel().getHeaderText(), equalTo(FakeHeadedPanelSupportTag.HEADER_TEXT));
        assertThat(panel.getModel().getText(), equalTo(FakeHeadedPanelSupportTag.TEXT));
    }

    public String getPage() {
        return "content/ecommerce/en.jsp";
    }
}
