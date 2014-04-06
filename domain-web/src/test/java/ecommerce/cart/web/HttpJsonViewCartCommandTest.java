package ecommerce.cart.web;

import com.jayway.jsonassert.JsonAssert;
import ecommerce.domain.web.CartJsonFormatter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static com.jayway.jsonassert.JsonAssert.collectionWithSize;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

public class HttpJsonViewCartCommandTest {


    private String json;
    private static MockHttpServletRequest request;
    private static MockHttpServletResponse response;

    @BeforeClass
    public static void init(){
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Before
    public void setUp() throws Exception {


        HttpJsonViewCartCommand command = new HttpJsonViewCartCommand(request, response);
        command.execute();
        json = response.getContentAsString();
    }

    @Test
    public void givenARequestWeShouldSeeTheDefaultIdInTheJSONResponse() throws Exception {
        JsonAssert.with(json).assertThat("$." + CartJsonFormatter.Fields.ID, greaterThan(0));
    }

    @Test
    public void givenARequestWeShouldSeeTheDefaultEmailInTheJSONResponse() throws Exception {
        JsonAssert.with(json).assertThat("$." + CartJsonFormatter.Fields.EMAIL, equalTo("anoncustomer@ecommerce.biz"));
    }

    @Test
    public void givenARequestWeShouldSeeTheDefaultProductsInTheJSONResponse() throws Exception {
        JsonAssert.with(json).assertThat("$." + CartJsonFormatter.Fields.PRODUCTS, is(collectionWithSize(equalTo(0))));
    }

}
