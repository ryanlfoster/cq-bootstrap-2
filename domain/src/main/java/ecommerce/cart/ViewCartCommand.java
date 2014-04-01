package ecommerce.cart;

import java.io.IOException;
import java.io.Writer;

public abstract class ViewCartCommand implements CartCommand {

    protected abstract Writer getWriter();

    protected abstract CartFormatter getFormatter();

    protected abstract String getId();

    @Override
    public void execute() {
        Cart cart = getCart();
        try {
            Writer writer = getWriter();
            writer.write(getFormatter().format(cart, getId()));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
