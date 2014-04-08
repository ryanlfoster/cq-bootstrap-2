package ecommerce.web.servlets;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckoutCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonGenerator generator = new JsonFactory().createJsonGenerator(resp.getWriter());
        generator.writeStartObject();
        generator.writeBooleanField("success" , true );
        generator.writeStringField("orderId" , "Order#" + Math.random() * Integer.MAX_VALUE );
        generator.writeEndObject();
        generator.flush();
    }
}
