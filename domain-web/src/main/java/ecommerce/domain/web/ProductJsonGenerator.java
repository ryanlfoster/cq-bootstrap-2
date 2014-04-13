package ecommerce.domain.web;

import ecommerce.domain.Product;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

public class ProductJsonGenerator {

    private static final Logger log = LoggerFactory.getLogger(ProductJsonGenerator.class);
    private Writer writer;

    public ProductJsonGenerator(Writer writer) {

        this.writer = writer;
    }

    public void writeProduct(JsonGenerator generator, Product product) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("code", product.getCode());
        generator.writeStringField("name", product.getName());
        generator.writeStringField("description", product.getDescription());
        generator.writeStringField("image", product.getImage());
        generator.writeEndObject();

    }

    public String writeProductJson(Product product) {
        try {
            JsonGenerator generator = new JsonFactory().createJsonGenerator(writer);
            writeProduct(generator, product);
            generator.flush();
            generator.close();
            return writer.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return "";
        }
    }

    public String writeProductsJson(Product... products) {
        try {
            JsonGenerator generator = new JsonFactory().createJsonGenerator(writer);
            generator.writeStartArray();
            for (Product product : products) {
                writeProduct(generator, product);
            }
            generator.writeEndArray();
            generator.flush();
            generator.close();
            return writer.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return "";
        }

    }
}
