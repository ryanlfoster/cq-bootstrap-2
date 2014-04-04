package ecommerce.cart.web;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HttpJsonViewCartCommandTest {


    @Test @Ignore("yet to implement")
    public void xsxsx() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        HttpJsonViewCartCommand command = new HttpJsonViewCartCommand(request, response);
        command.execute();
        String json = response.getContentAsString();
        assertThat(json, equalTo("{ product : [] }"));

    }
}
