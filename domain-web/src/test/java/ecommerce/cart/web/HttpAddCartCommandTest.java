package ecommerce.cart.web;

import ecommerce.domain.PurchaseProduct;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HttpAddCartCommandTest {

    @Test
    public void xxx() throws Exception {

        MockHttpSession session = new MockHttpSession();
        MockHttpServletRequest request = new MockHttpServletRequest();

        request.setSession(session);

        String s = String.format("{ \"sku\" : \"%s\" , \"name\" : \"%s\" , \"cost\" : \"%d\" }" , "SKU0" , "Product #1" , 10);

        request.setContent(s.getBytes());

        new HttpAddCartCommand(request).execute();

        Map<String, PurchaseProduct> cart = (Map<String, PurchaseProduct>) session.getAttribute("cart");

        assertThat(cart, is(notNullValue()));

        assertThat(cart.containsKey("SKU0"), is(true));


    }


}
