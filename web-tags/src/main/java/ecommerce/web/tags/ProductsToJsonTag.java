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
            ProductJsonGenerator.writeJson(generator, new Product(){
                            @Override
                            public String getName() {
                                return "Product Information #" ;
                            }

                            @Override
                            public String getDescription() {
                                return getLoremIpsum();
                            }

                            @Override
                            public String getImageSource() {
                                return "//placekitten.com/340/300";
                            }

                            @Override
                            public int getQuantity() {
                                return 0;
                            }

                            @Override
                            public String getCode() {
                                return String.valueOf(sku);
                            }
                        });
        }

        generator.writeEndArray();

        generator.flush();

        getJspContext().setAttribute("productsData" , sw.toString());

    }


    String getLoremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!";
    }
}

interface Product {

    String getName();
    String getDescription();
    String getImageSource();
    int getQuantity();
    String getCode();
}

class ProductJsonGenerator {

    public static void writeJson(JsonGenerator generator , Product product){
        try {
            generator.writeStartObject();
            generator.writeStringField("code" , product.getCode());
            generator.writeStringField("sku" , product.getCode());
            generator.writeStringField("name" , product.getName());
            generator.writeStringField("description" , product.getDescription());
            generator.writeStringField("image" , product.getImageSource());
            generator.writeNumberField("quantity" , product.getQuantity());
            generator.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}



