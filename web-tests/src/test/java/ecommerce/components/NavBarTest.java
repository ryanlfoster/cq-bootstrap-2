package ecommerce.components;

import ecommerce.fake.FakeNavBarHeaderModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class NavBarTest {

    private String page;

    @Before
    public void setUp() throws Exception {
        String servername = System.getProperty("test.host.servername");
        String port = System.getProperty("test.host.port");
        String context = System.getProperty("test.host.context");
        page = String.format("http://%s:%s%s", servername, port, context) + "content/ecommerce/en.jsp";
    }

    @Test
    public void confirmNavBarHeaderStructure() throws Exception {
        final Document document = Jsoup.connect(page).timeout(10000).get();
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(document.select("nav").get(0));
        nav.getToogleButton().assertValidStructure();
    }


    @Test
    public void navBarShouldBeAvailable() throws Exception {
        final Document document = Jsoup.connect(page).timeout(10000).get();
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(document.select("nav").get(0));
        nav.getBrandHtml().assertBrand(FakeNavBarHeaderModel.NAV_BRAND);

    }

    @Test
    public void navBarShouldHaveNavBarCollapseAndTargetShouldExist() throws Exception {

        final Document document = Jsoup.connect(page).timeout(10000).get();
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(document.select("nav").get(0));
        HtmlNavBarCollapseTarget target = nav.getToogleButton().getCollapseTarget();
        assertThat(target.getTargetId(), equalTo("#bs-example-navbar-collapse-1"));
    }

    @Test
    public void confirmToggleButtonTargetExists() throws Exception {

        final Document document = Jsoup.connect(page).timeout(10000).get();
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(document.select("nav").get(0));
        Element target = nav.select(nav.getToogleButton().getCollapseTarget());
        assertNotNull(target);
    }

    @Test
    public void navHasRequiredNumberOfLinks() throws Exception {

        final Document document = Jsoup.connect(page).timeout(10000).get();
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(document.select("nav").get(0));
        HTMLNavBarLinks links = nav.getLinks();
        assertThat(links.size(), equalTo(3));
        assertThat(links.getLinks().get(0).isActive(), is(true));
        assertThat(links.getLinks().get(1).isActive(), is(false));
        assertThat(links.getLinks().get(2).isActive(), is(false));
    }


}

