package ecommerce.content;

import ecommerce.components.HtmlHeadedPanelModel;
import ecommerce.components.HtmlPanelModel;
import ecommerce.domain.HeadedPanelModel;
import ecommerce.domain.PanelModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@Ignore("all these integration tests which are not run yet")
public class EnglishPageTest {

    @Test
    public void pageRendersWithAllPanels() throws Exception {

        Document page = Jsoup.connect("http://localhost:4502/content/ecommerce/en.html?wcmmode=disabled").get();
        assertPanel(new HtmlPanelModel(page.select(".panel").get(0)), "[ No Text Specified ]");
        assertPanel(new HtmlHeadedPanelModel(page.select(".panel").get(1)) , "[ Header Text ]" , "[ No Text Specified ]");
        assertPanel(new HtmlPanelModel(page.select(".panel").get(2)), "[ No Text Specified ]");
        assertPanel(new HtmlHeadedPanelModel(page.select(".panel").get(3)) , "Beer Ipsum" , "cold filter caramel malt autolysis barley terminal gravity. wort chiller wort chiller; dry stout pitching brewhouse, alpha acid anaerobic, hand pump.");

    }

    private void assertPanel(HeadedPanelModel panel , String header ,  String text ) {
        assertThat(panel.getHeaderText(), equalTo(header));
        assertThat(panel.getText(), equalTo(text));
    }

    private void assertPanel(PanelModel panel, String text) {
        assertThat(panel.getText(), equalTo(text));
    }


}
