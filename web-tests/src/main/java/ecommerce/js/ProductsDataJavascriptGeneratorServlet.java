package ecommerce.js;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ProductsDataJavascriptGeneratorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Velocity.init();

        VelocityContext context = new VelocityContext();

        StringWriter w = new StringWriter();

        Velocity.mergeTemplate("data.js.vm", context, w );


        System.out.println(w);

        resp.setContentType("application/javascript");
        PrintWriter writer = resp.getWriter();
        writer.write(w.toString());
        writer.flush();
        writer.close();

    }

}




