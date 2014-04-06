package ecommerce.web.servlets;

import ecommerce.cart.web.HttpJsonViewCartCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new HttpJsonViewCartCommand(request, response).execute();
    }

}


