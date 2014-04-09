package ecommerce.cart.web;

import ecommerce.domain.Product;
import ecommerce.domain.web.ProductMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JSONAddCartCommand extends HttpAddCartCommand {

    public JSONAddCartCommand(HttpServletRequest request) {
        super(request);
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
