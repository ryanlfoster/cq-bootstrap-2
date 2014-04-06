package ecommerce.cart.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CartFormatter;
import ecommerce.cart.ViewCartCommand;
import ecommerce.domain.web.CartJsonFormatter;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class HttpJsonViewCartCommand extends ViewCartCommand {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpJsonViewCartCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        response.setContentType("application/json");
        this.response = response;
    }

    @Override
    protected Writer getWriter() {
        try {
            return response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StringWriter();
    }

    @Override
    protected CartFormatter getFormatter() {
        return new CartJsonFormatter();
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
