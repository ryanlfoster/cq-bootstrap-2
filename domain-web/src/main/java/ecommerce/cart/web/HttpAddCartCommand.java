package ecommerce.cart.web;

import ecommerce.cart.AddCartComand;
import ecommerce.cart.Cart;
import ecommerce.domain.Product;
import ecommerce.domain.web.ProductMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpAddCartCommand extends AddCartComand {

    private HttpServletRequest request;

    public HttpAddCartCommand(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Cart getCart() {
        return new HttpCart(request);
    }

    @Override
    public Product getProduct() {
        try {
            return (new ProductMapper().parse(request.getReader()));
        } catch (IOException e) {
            return new Product();
        }
    }

}
