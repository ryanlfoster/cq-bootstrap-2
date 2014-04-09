package ecommerce.http.fake.servlets;

import ecommerce.cart.web.HttpViewCartCommand;
import ecommerce.cart.web.output.JsonCartWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONViewCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new HttpViewCartCommand(request, new JsonCartWriter(response.getWriter())).execute();
    }
}


