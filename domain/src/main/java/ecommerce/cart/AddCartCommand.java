package ecommerce.cart;

import ecommerce.domain.Product;

public abstract class AddCartCommand implements CartCommand {

    abstract protected Product getProduct();

    @Override
    public final void execute() {
        Cart cart = getCart();
        cart.add(getProduct());
    }
}
