package ecommerce.http.servlets;

import ecommerce.cart.web.HttpCheckoutCartCommand;
import ecommerce.cart.web.output.JsonCheckoutResponseWriter;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.selectors", value = "cart.checkout"),
        @Property(name = "sling.servlet.extensions", value = "do"),
        @Property(name = "sling.servlet.methods", value = "POST")
})
public class JSONCheckoutCartSlingServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        JsonCheckoutResponseWriter success = new JsonCheckoutResponseWriter(response.getWriter());
        JsonCheckoutResponseWriter failure = new JsonCheckoutResponseWriter(response.getWriter());
        response.setContentType("application/json");
        new HttpCheckoutCartCommand(request, success, failure).execute();
    }
}

