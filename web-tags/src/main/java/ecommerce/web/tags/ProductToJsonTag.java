package ecommerce.web.tags;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class ProductToJsonTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);
        new StaticProductGenerator().generateProduct(generator, 1);
        generator.flush();
        getJspContext().setAttribute("productData" , sw.toString());
    }
}


