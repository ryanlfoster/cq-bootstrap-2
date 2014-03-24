package ecommerce.components;

import ecommerce.domain.HeadedPanel;
import ecommerce.domain.Panel;
import ecommerce.fake.FakeHeadedPanelSupportTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HeadedPanelTest {

    private String page;

    @Before
    public void setUp() throws Exception {
        String servername = System.getProperty("test.host.servername");
        String port = System.getProperty("test.host.port");
        String context = System.getProperty("test.host.context");
        page = String.format("http://%s:%s%s", servername, port, context) + "content/ecommerce/en.jsp";
    }


    @Test
    public void panelShouldBeRenderedWithDefaultText() throws Exception {
        final Document document = Jsoup.connect(page).get();
        HeadedPanel panel = new HeadedPanel(new HtmlHeadedPanelModel(document.getElementById("panel_2")));
        assertThat(panel.getModel().getHeaderText(), equalTo(FakeHeadedPanelSupportTag.HEADER_TEXT));
        assertThat(panel.getModel().getText(), equalTo(FakeHeadedPanelSupportTag.TEXT));
    }

}
