package ecommerce.cart.web;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class HttpCartTest {

    @Test
    public void cartShouldBeCreatedIfNoSessionExists() throws Exception {


        MockHttpServletRequest request = new MockHttpServletRequest();

        HttpCart httpCart = new HttpCart(request);

        httpCart.store(httpCart.getProducts());

        HttpSession session = request.getSession();
        assertThat(session, not(nullValue()));
        assertThat(session.isNew(), is(true));

        Object cart = session.getAttribute("cart");
        assertThat(cart, not(nullValue()));


    }

    @Test
    public void cartShouldBeCreatedInCurrentSession() throws Exception {

        MockServletContext servletContext = new MockServletContext();
        MockHttpSession mockHttpSession = new MockHttpSession(servletContext);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setSession(mockHttpSession);

        HttpCart httpCart = new HttpCart(request);

        httpCart.store(httpCart.getProducts());

        HttpSession session = request.getSession();
        assertThat(session, not(nullValue()));
        assertThat(session.isNew(), is(false));

        Object cart = session.getAttribute("cart");
        assertThat(cart, not(nullValue()));
    }
}
