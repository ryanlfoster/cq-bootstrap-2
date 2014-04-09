package ecommerce.cart.web;

import ecommerce.cart.CheckoutFailureResponseWriter;
import ecommerce.cart.CheckoutSuccessResponseWriter;
import ecommerce.domain.PurchaseProduct;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class HttpCheckoutCartCommandTest {

    @Test
    public void cartShouldBeLoadedFromSession() throws Exception {

        MockHttpSession session = new MockHttpSession();
        Map<String, PurchaseProduct> products = new HashMap<String, PurchaseProduct>();
        session.setAttribute("cart" , products);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setSession(session);

        HttpCheckoutCartCommand command = new HttpCheckoutCartCommand(request, Mockito.mock(CheckoutSuccessResponseWriter.class), Mockito.mock(CheckoutFailureResponseWriter.class));

        assertThat(command.getCart(), not(nullValue()));
        Map<String, PurchaseProduct> expected = command.getCart().getProducts();
        assertThat(expected, equalTo(products));
    }
}
