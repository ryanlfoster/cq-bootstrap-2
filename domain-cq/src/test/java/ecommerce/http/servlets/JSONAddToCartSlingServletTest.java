package ecommerce.http.servlets;

import ecommerce.cart.Cart;
import ecommerce.cart.web.HttpCart;
import org.apache.sling.commons.testing.sling.MockSlingHttpServletRequest;
import org.apache.sling.commons.testing.sling.MockSlingHttpServletResponse;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JSONAddToCartSlingServletTest {

    @Test
    public void onPostShouldAddTheJSONPayloadToTheCartAsAProduct() throws Exception {

        JSONAddToCartSlingServlet servlet = new JSONAddToCartSlingServlet();

        final MockHttpServletRequest r = new MockHttpServletRequest("POST", "/content/commerce/en.cart.add.do");
        r.setContent("{ \"sku\": \"1\",   \"code\":\"1\",\"name\":\"Product Information #\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!\",\"image\":\"//placekitten.com/340/300\",\"quantity\":1}".getBytes());

        final MockHttpSession mockHttpSession = new MockHttpSession();
        MockSlingHttpServletRequest request =
                new MockSlingHttpServletRequest("/content/commerce/en",
                        "cart.add", "do", "", "") {

                    @Override
                    public HttpSession getSession() {
                        return mockHttpSession;
                    }

                    @Override
                    public HttpSession getSession(boolean create) {
                        return mockHttpSession;
                    }

                    @Override
                    public BufferedReader getReader() {
                        try {
                            return r.getReader();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                };
        MockSlingHttpServletResponse response = new MockSlingHttpServletResponse();
        servlet.doPost(request, response);
        Cart cart = new HttpCart(request);
        assertNotNull(cart.getProducts());
        assertEquals(cart.getProducts().size(), 1);
    }

}

