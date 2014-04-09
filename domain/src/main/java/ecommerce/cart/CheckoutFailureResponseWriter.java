package ecommerce.cart;

public interface CheckoutFailureResponseWriter extends CheckoutResponseWriter {

    void writeFailure();
}
