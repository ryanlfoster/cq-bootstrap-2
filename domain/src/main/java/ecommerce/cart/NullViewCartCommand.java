package ecommerce.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When ever an error occurs that requires a ViewCartCommand an instance of this object will be returned
 * NullObject pattern
 */
public class NullViewCartCommand extends ViewCartCommand {

    private static final Logger log = LoggerFactory.getLogger(NullViewCartCommand.class);

    protected NullViewCartCommand() {
        super(new LoggerCartWriter());
    }


    @Override
    protected String getId() {
        return "-";
    }

    @Override
    public void execute() {
        log.debug("Nothing to execute");
    }

    @Override
    public Cart getCart() {
        return new NullCart();
    }
}
