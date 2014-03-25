package ecommerce.components;

import ecommerce.domain.Panel;
import ecommerce.domain.PanelModel;
import ecommerce.fake.FakeHeadedPanelSupportTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PanelTest {

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
        final Document document = Jsoup.connect(page).timeout(10000).get();
        Panel panel = new Panel(new HtmlPanelModel(document.getElementById("panel_1")));
        assertThat(panel.getModel().getText(), equalTo(FakeHeadedPanelSupportTag.TEXT));
    }


}

