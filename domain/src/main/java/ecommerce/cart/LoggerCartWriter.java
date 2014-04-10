package ecommerce.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerCartWriter implements CartWriter {

    private static final Logger log = LoggerFactory.getLogger(LoggerCartWriter.class);

    @Override
    public void write(String id, Cart cart) {
        log.debug("Nothing to write this object will have been returned from an exception !!");
    }
}
