package ecommerce.cart;

public interface CartCommand {
    void execute();
    Cart getCart();
}
