package ecommerce.cart.web.output;

import com.jayway.jsonassert.JsonAssert;
import ecommerce.cart.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.PurchaseProduct;
import org.junit.Test;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class JsonCartWriterTest {

    @Test
    public void cartIsWrittenAsJson() throws Exception {
        StringWriter sw = new StringWriter();
        JsonCartWriter writer = new JsonCartWriter(sw);

        writer.write( "1" ,
                new Cart() {
            @Override
            protected void store(Map<String, PurchaseProduct> products) {
            }

            @Override
            public Map<String, PurchaseProduct> getProducts() {
                return new HashMap<String, PurchaseProduct>(){{
                    put("0", new PurchaseProduct(new Product("name", "desc", "image", "code", 1.00)));
                }};
            }
        });

        JsonAssert.with(sw.toString()).assertThat("$.id", equalTo("1"));
        JsonAssert.with(sw.toString()).assertThat("$.products", hasSize(equalTo(1)));
        JsonAssert.with(sw.toString()).assertThat("$.products[0].code", equalTo("SKU0"));
    }
}
