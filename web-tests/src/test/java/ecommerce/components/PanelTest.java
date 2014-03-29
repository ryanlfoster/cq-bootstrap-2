package ecommerce.components;

import ecommerce.domain.Panel;
import ecommerce.fake.FakeHeadedPanelSupportTag;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PanelTest extends AbstractViewTest {


    @Test
    public void panelShouldBeRenderedWithDefaultText() throws Exception {
        final Document document = getDocument();
        Panel panel = new Panel(new HtmlPanelModel(document.getElementById("panel_1")));
        assertThat(panel.getModel().getText(), equalTo(FakeHeadedPanelSupportTag.TEXT));
    }


    public String getPage() {
        return "content/ecommerce/en.jsp";
    }
}

