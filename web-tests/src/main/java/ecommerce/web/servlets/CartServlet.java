package ecommerce.web.servlets;

import ecommerce.cart.web.HttpAddCartCommand;
import ecommerce.cart.web.HttpJsonViewCartCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends HttpServlet {


    private final HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new HttpAddCartCommand(request).execute();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new HttpJsonViewCartCommand(request, response).execute();
    }

}


