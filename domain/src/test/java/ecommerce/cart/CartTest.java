package ecommerce.cart;

import ecommerce.domain.Product;
import ecommerce.domain.PurchaseProduct;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CartTest {

    @Test
    public void cartShouldContainAddedProduct() throws Exception {


        Product product = new Product();
        product.setCode("0");
        product.setDescription("description");
        product.setName("product #1");

        final Map<String, PurchaseProduct> prods = new HashMap<String, PurchaseProduct>();

        Cart cart = new Cart(){

            @Override
            protected void store(Map<String, PurchaseProduct> products) {
                prods.putAll(products);
            }

            @Override
            public Map<String, PurchaseProduct> getProducts() {
                return prods;
            }
        };

        cart.add(product);

        assertThat(prods.size(), equalTo(1));

    }
}
