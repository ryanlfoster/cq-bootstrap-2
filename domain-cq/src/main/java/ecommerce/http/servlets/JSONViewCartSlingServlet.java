package ecommerce.http.servlets;

import ecommerce.cart.CartWriter;
import ecommerce.cart.ViewCartCommand;
import ecommerce.cart.web.HttpViewCartCommand;
import ecommerce.cart.web.output.JsonCartWriter;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Component
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.selectors", value = "cart.view"),
        @Property(name = "sling.servlet.extensions", value = "do"),
        @Property(name = "sling.servlet.methods", value = "GET")
})
public class JSONViewCartSlingServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        getViewCartCommand(request , response).execute();
    }


    CartWriter getCartWriter(Writer writer) {
        return new JsonCartWriter(writer);
    }

    ViewCartCommand getViewCartCommand(HttpServletRequest request , HttpServletResponse response) throws IOException {
        return new HttpViewCartCommand(request, getCartWriter(response.getWriter()));
    }
}


/*
interface ViewCart {

    ViewCartCommand getViewCartCommand() throws IOException;
}
*/

/*class JSONHttpViewCart implements ViewCart {


    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public JSONHttpViewCart(HttpServletRequest request , HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public CartWriter getCartWriter(Writer writer) {
        return new JsonCartWriter(writer);
    }

    public ViewCartCommand getViewCartCommand() {
        try {
            return new HttpViewCartCommand(request, getCartWriter(response.getWriter()));
        } catch (IOException e) {
            return new NullViewCartCommand();
        }
    }

}*/

