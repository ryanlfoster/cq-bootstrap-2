package ecommerce.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Writer;

public abstract class ViewCartCommand implements CartCommand {


    private CartWriter cartWriter;

    protected abstract String getId();

    protected ViewCartCommand(CartWriter cartWriter) {
        this.cartWriter = cartWriter;
    }

    @Override
    public void execute() {
        cartWriter.write(getId(), getCart());
    }
}
