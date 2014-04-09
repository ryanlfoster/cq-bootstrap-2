package ecommerce.http.fake.servlets;

import ecommerce.cart.web.HttpCheckoutCartCommand;
import ecommerce.cart.web.output.JsonCheckoutResponseWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONCheckoutCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpCheckoutCartCommand(req, new JsonCheckoutResponseWriter(resp.getWriter()), new JsonCheckoutResponseWriter(resp.getWriter())).execute();
    }
}

