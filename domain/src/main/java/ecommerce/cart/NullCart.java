package ecommerce.cart;

import ecommerce.domain.PurchaseProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class NullCart extends Cart {

    private static final Logger log = LoggerFactory.getLogger(NullCart.class);

    @Override
    protected void store(Map<String, PurchaseProduct> products) {
        log.debug("Noting to store to");
    }

    @Override
    public Map<String, PurchaseProduct> getProducts() {
        return new HashMap<String, PurchaseProduct>();
    }
}
