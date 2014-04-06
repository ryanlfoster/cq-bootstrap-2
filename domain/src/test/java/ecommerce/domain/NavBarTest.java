package ecommerce.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class NavBarTest {

    @Test
    public void navBarShouldHaveDefaultHeader() throws Exception {

        NavBar navBar = new NavBar();
        assertThat(navBar.getHeader(), not(nullValue()));
    }

    @Test
    public void navBarShouldHaveDefaultBrand() throws Exception {

        NavBar navBar = new NavBar();
        assertThat(navBar.getHeader().getBrand(), equalTo(NavBar.DEFAULT_BRAND));
    }

    @Test
    public void navBarGivenAHeader_ShouldUseHeader() throws Exception {
        NavBar navBar = new NavBar();
        final String brand = "Mock Brand";

        navBar.setHeader(new NavBarHeaderUI() {
            @Override
            public String getBrand() {
                return brand;
            }
        });
        assertThat(navBar.getHeader().getBrand(), equalTo(brand));
    }

    @Test
    public void givenListOfLinks_ShouldHaveLinks() throws Exception {
        NavBar navBar = new NavBar();

        class MockNavBarLinkModel implements NavBarLinkModel {
            @Override
            public boolean isActive() {
                return false;
            }

            @Override
            public String getHref() {
                return null;
            }

            @Override
            public String getText() {
                return null;
            }
        }
        navBar.setLinks(new MockNavBarLinkModel(), new MockNavBarLinkModel());

        assertThat(navBar.getLinks().size(), equalTo(2));

    }
}
