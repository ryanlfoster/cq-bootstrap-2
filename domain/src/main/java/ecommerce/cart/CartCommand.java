package ecommerce.cart;

public interface CartCommand {

    /**
     * Command pattern execute method
     */
    void execute();

    /**
     *
     * @return the cart to be operated upon
     */
    Cart getCart();
}

