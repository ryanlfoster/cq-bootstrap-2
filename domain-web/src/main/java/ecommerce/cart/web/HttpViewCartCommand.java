package ecommerce.cart.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CartWriter;
import ecommerce.cart.ViewCartCommand;

import javax.servlet.http.HttpServletRequest;

public class HttpViewCartCommand extends ViewCartCommand {

    private HttpServletRequest request;

    public HttpViewCartCommand(HttpServletRequest request, CartWriter cartWriter) {
        super(cartWriter);
        this.request = request;
    }

    @Override
    protected String getId() {
        return request.getSession(true).getId();
    }

    @Override
    public Cart getCart() {
        return new HttpCart(request);
    }
}
