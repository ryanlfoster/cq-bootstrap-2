package ecommerce.cart.web;

import ecommerce.cart.AddCartCommand;
import ecommerce.cart.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.web.ProductMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class HttpAddCartCommand extends AddCartCommand {

    protected HttpServletRequest request;

    public HttpAddCartCommand(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Cart getCart() {
        return new HttpCart(request);
    }

    public abstract Product getProduct();

}

