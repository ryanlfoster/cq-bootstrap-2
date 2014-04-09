package ecommerce.components;

import ecommerce.web.tags.fake.FakeNavBarHeaderModel;
import org.jsoup.nodes.Element;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class NavBarTest extends AbstractViewTest {


    @Test
    public void confirmNavBarHeaderStructure() throws Exception {
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(getDocument().select("nav").get(0));
        nav.getToogleButton().assertValidStructure();
    }


    @Test
    public void navBarShouldBeAvailable() throws Exception {
        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(getDocument().select("nav").get(0));
        nav.getBrandHtml().assertBrand(FakeNavBarHeaderModel.NAV_BRAND);

    }

    @Test
    public void navBarShouldHaveNavBarCollapseAndTargetShouldExist() throws Exception {

        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(getDocument().select("nav").get(0));
        HtmlNavBarCollapseTarget target = nav.getToogleButton().getCollapseTarget();
        assertThat(target.getTargetId(), equalTo("#bs-example-navbar-collapse-1"));
    }

    @Test
    public void confirmToggleButtonTargetExists() throws Exception {

        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(getDocument().select("nav").get(0));
        Element target = nav.select(nav.getToogleButton().getCollapseTarget());
        assertNotNull(target);
    }

    @Test
    public void navHasRequiredNumberOfLinks() throws Exception {

        HtmlNavBarHeaderUIModel nav = new HtmlNavBarHeaderUIModel(getDocument().select("nav").get(0));
        HTMLNavBarLinks links = nav.getLinks();
        assertThat(links.size(), equalTo(3));
        assertThat(links.getLinks().get(0).isActive(), is(true));
        assertThat(links.getLinks().get(1).isActive(), is(false));
        assertThat(links.getLinks().get(2).isActive(), is(false));
    }


    public String getPage() {
        return "content/ecommerce/en.jsp";
    }
}

