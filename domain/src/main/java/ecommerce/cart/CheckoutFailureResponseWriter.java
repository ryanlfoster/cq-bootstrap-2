package ecommerce.cart;

public interface CheckoutFailureResponseWriter extends CheckoutResponseWriter {

    void failed();

    void writeFailure();
}
