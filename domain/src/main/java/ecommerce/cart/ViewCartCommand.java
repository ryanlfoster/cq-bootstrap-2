package ecommerce.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

public abstract class ViewCartCommand implements CartCommand {

    private static final Logger log = LoggerFactory.getLogger(ViewCartCommand.class);


    protected abstract Writer getWriter();

    protected abstract CartFormatter getFormatter();

    protected abstract String getId();

    @Override
    public void execute() {
        Cart cart = getCart();
        try {
            Writer writer = getWriter();
            String id = getId();
            writer.write(getFormatter().format(cart, id));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }

    }
}
