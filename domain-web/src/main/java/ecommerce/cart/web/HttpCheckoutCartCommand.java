package ecommerce.cart.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CheckoutCartCommand;
import ecommerce.cart.CheckoutFailureResponseWriter;
import ecommerce.cart.CheckoutSuccessResponseWriter;

import javax.servlet.http.HttpServletRequest;

public class HttpCheckoutCartCommand extends CheckoutCartCommand {

    private HttpServletRequest request;

    public HttpCheckoutCartCommand(HttpServletRequest request,CheckoutSuccessResponseWriter success, CheckoutFailureResponseWriter failure) {
        super(success, failure);
        this.request = request;
    }

    @Override
    public Cart getCart() {
        return new HttpCart(request);
    }
}
