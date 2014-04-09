package ecommerce.cart;

public interface CheckoutResponseWriter {

    void writeOrderId();

    void complete();
}
