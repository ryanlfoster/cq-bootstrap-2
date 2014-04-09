package ecommerce.cart.web.output;

import com.jayway.jsonassert.JsonAssert;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.*;

public class JsonCheckoutResponseWriterTest {

    @Test
    public void successCheckoutJSONResponseShouldContainSuccessAndOrderId() throws Exception {

        StringWriter sw = new StringWriter();
        JsonCheckoutResponseWriter writer = new JsonCheckoutResponseWriter(sw);

        writer.success();

        JsonAssert.with(sw.toString()).assertThat("$.orderId", not(nullValue()));
        JsonAssert.with(sw.toString()).assertThat("$.success", equalTo(true));
    }

    @Test
    public void failedCheckoutJSONResponseShouldContainSuccess() throws Exception {

        StringWriter sw = new StringWriter();
        JsonCheckoutResponseWriter writer = new JsonCheckoutResponseWriter(sw);

        writer.failed();

        JsonAssert.with(sw.toString()).assertThat("$.orderId", is(nullValue()));
        JsonAssert.with(sw.toString()).assertThat("$.success", equalTo(false));

    }
}
