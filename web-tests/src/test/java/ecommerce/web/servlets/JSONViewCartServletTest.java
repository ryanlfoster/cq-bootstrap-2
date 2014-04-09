package ecommerce.web.servlets;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class JSONViewCartServletTest {

    @Test
    public void responseShouldContainJsonResposeOfCart() throws Exception {

        JSONViewCartServlet servlet = new JSONViewCartServlet();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        servlet.doGet(request, response);

        System.out.println(response.getContentAsString());

    }
}
