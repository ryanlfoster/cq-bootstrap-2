package ecommerce.cart;

import ecommerce.domain.Product;

public abstract class AddCartComand implements CartCommand {

    abstract protected Product getProduct();

    @Override
    public final void execute() {
        Cart cart = getCart();
        cart.add(getProduct());
    }
}
