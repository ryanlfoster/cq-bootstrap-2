package ecommerce.domain.web;

import com.jayway.jsonassert.JsonAssert;
import ecommerce.cart.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.PurchaseProduct;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static ecommerce.cart.CartFormatter.Fields;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CartJsonFormatterTest {

    public static class IOExceptionAnswer implements Answer<Object> {

        public Object answer(InvocationOnMock invocation) throws Throwable {
            throw new IOException("fake io exception on writer");
        }

    }

    @Test
    public void exceptionShouldBeCaughtAndLogged_shouldReturnDefaultString() throws Exception {

        final Writer writer = Mockito.mock(Writer.class, new IOExceptionAnswer());
        CartJsonFormatter formatter = new CartJsonFormatter(writer);
        Cart mock = Mockito.mock(Cart.class);
        String id = "1";
        String json = formatter.format(mock, id);
        Mockito.verify(writer);
        assertThat(json, equalTo("{}"));
    }

    @Test
    public void shouldContainCustomerInformation() throws Exception {
        Cart cart = stubbedCart(new HashMap<String, PurchaseProduct>());
        String json = new CartJsonFormatter().format(cart, "1");
        JsonAssert.with(json).assertThat("$." + Fields.ID, equalTo("1"));
        JsonAssert.with(json).assertThat("$." + Fields.EMAIL, equalTo(Cart.DEFAULT_CUSTOMER_EMAIL));
        JsonAssert.with(json).assertThat("$." + Fields.PRODUCTS, is(JsonAssert.collectionWithSize(equalTo(0))));
    }

    @Test
    public void shouldContainProducts() throws Exception {
        Cart cart = stubbedCart(new HashMap<String, PurchaseProduct>() {{
            put("0", new PurchaseProduct(new Product("", "", "", "0", 1.00)));
        }});
        String json = new CartJsonFormatter().format(cart, "1");
        int index = 0;
        JsonAssert.with(json).assertThat("$." + Fields.ID, equalTo("1"));
        JsonAssert.with(json).assertThat("$." + Fields.EMAIL, equalTo(Cart.DEFAULT_CUSTOMER_EMAIL));
        JsonAssert.with(json).assertThat("$." + Fields.PRODUCTS, is(JsonAssert.collectionWithSize(equalTo(1))));
        JsonAssert.with(json).assertThat("$." + Fields.PRODUCTS + "[" + index + "]." + Fields.ProductFields.CODE, equalTo("SKU0"));
        JsonAssert.with(json).assertThat("$." + Fields.PRODUCTS + "[" + index + "]." + Fields.ProductFields.QUANTITY, equalTo(1));
        JsonAssert.with(json).assertThat("$." + Fields.PRODUCTS + "[" + index + "]." + Fields.ProductFields.TOTALITEMCOST, equalTo(1.0));

    }

    private Cart stubbedCart(final HashMap<String, PurchaseProduct> products) {
        return new Cart() {
            @Override
            protected void store(Map<String, PurchaseProduct> products) {

            }

            @Override
            public Map<String, PurchaseProduct> getProducts() {
                return products;
            }
        };
    }


}
