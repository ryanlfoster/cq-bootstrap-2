package ecommerce.web.tags;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class ProductsToJsonTag extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);
        generator.writeStartArray();
        for(int i = 0 ; i < 21 ; i++) {
            final int sku = i;
            new StaticProductGenerator().generateProduct(generator, sku);
        }
        generator.writeEndArray();
        generator.flush();
        getJspContext().setAttribute("productsData" , sw.toString());
    }

}



