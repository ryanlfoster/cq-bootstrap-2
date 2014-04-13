package ecommerce.domain.web;

import ecommerce.domain.Product;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

public class ProductJsonGenerator {

    private static final Logger log = LoggerFactory.getLogger(ProductJsonGenerator.class);

    public static String writeJson(Product ... products){
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);
            generator.writeStartArray();
            for (Product product : products) {
                write(generator, product);
            }
            generator.writeEndArray();
            generator.flush();
            generator.close();
            return sw.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return "";
        }
    }


    private static void write(JsonGenerator generator, Product product){
        try {
            generator.writeStartObject();
            generator.writeStringField("code", product.getCode());
            generator.writeStringField("name", product.getName());
            generator.writeStringField("description", product.getDescription());
            generator.writeStringField("image", product.getImage());
            generator.writeEndObject();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    public static String writeJson(Product product) {
        try {

            StringWriter sw = new StringWriter();
            JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);
            write(generator, product);
            generator.flush();
            generator.close();
            return sw.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return "";
        }

    }

}
