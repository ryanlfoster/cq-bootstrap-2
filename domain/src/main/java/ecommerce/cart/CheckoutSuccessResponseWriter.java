package ecommerce.cart;

public interface CheckoutSuccessResponseWriter extends CheckoutResponseWriter {
    void success();

    void writeSuccess();
}
