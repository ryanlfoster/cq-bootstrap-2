package ecommerce.http.cq.servlets;

import com.jayway.jsonassert.JsonAssert;
import org.apache.sling.commons.testing.sling.MockSlingHttpServletRequest;
import org.apache.sling.commons.testing.sling.MockSlingHttpServletResponse;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JSONCheckoutCartSlingServletTest {

    @Test
    public void successCheckoutShouldReturnSuccessfulJsonResponse() throws Exception {

        JSONCheckoutCartSlingServlet servlet = new JSONCheckoutCartSlingServlet();

        final MockHttpSession mockHttpSession = new MockHttpSession();


        MockSlingHttpServletRequest request = new MockSlingHttpServletRequest("/content/commerce/en", "cart.checkout", "do", "", ""){

            @Override
            public HttpSession getSession() {
                return mockHttpSession;
            }

            @Override
            public HttpSession getSession(boolean create) {
                return mockHttpSession;
            }

        };

        final MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.doPost(request, new MockSlingHttpServletResponse(){
            @Override
            public PrintWriter getWriter() throws IOException {
                return response.getWriter();
            }

            @Override
            public void setContentType(String contentType) {
                response.setContentType(contentType);
            }
        });


        assertThat(response.getContentType(), equalTo("application/json"));
        String jsonResponse = response.getContentAsString();
        assertThat(jsonResponse, not(nullValue()));
        JsonAssert.with(jsonResponse).assertThat("$.success", is(true));
        JsonAssert.with(jsonResponse).assertThat("$.orderId", is(notNullValue()));
        JsonAssert.with(jsonResponse).assertThat("$.orderId", containsString("OrderId#"));

    }
}
