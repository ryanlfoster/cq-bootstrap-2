package ecommerce.http.cq.servlets;

import ecommerce.cart.web.JSONAddCartCommand;
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
        @Property(name = "sling.servlet.selectors", value = "cart.add"),
        @Property(name = "sling.servlet.extensions", value = "do"),
        @Property(name = "sling.servlet.methods", value = "POST")
})

public class JSONAddToCartSlingServlet extends SlingAllMethodsServlet {
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        new JSONAddCartCommand(request).execute();
    }
}
