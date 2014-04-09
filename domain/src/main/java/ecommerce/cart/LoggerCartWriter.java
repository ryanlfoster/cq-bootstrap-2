package ecommerce.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerCartWriter implements ecommerce.cart.CartWriter {
    private static final Logger log = LoggerFactory.getLogger(LoggerCartWriter.class);

    @Override
    public void addCustomerInformation(String id) {
        log.debug("Adding Customer Information ID = {} " , id  );
    }

    @Override
    public void addProducts(Cart cart) {
        log.debug("Adding Products From Cart");
    }

    @Override
    public void complete() {
        log.debug("Complete");
    }
}
