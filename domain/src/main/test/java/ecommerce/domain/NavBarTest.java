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
}
