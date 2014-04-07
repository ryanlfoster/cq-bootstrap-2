package ecommerce.domain.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CartFormatter;
import ecommerce.domain.PurchaseProduct;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import static ecommerce.cart.CartFormatter.Fields;

public class CartJsonFormatter implements CartFormatter {

    private Writer writer;

    private JsonWriter jsonWriter;

    public CartJsonFormatter() {
        writer = new StringWriter();
        jsonWriter = new JacksonJsonWriter(writer);

    }

    public CartJsonFormatter(java.io.Writer writer) {
        this.writer = writer;
        jsonWriter = new JacksonJsonWriter(this.writer);
    }

    public String format(Cart cart, String id) {
        jsonWriter.addCustomerInformation(id);
        jsonWriter.addProducts(cart);
        return jsonWriter.generate();
    }


}


interface JsonWriter {

    void addCustomerInformation(String id);

    void addProducts(Cart cart);

    String generate();
}

class JacksonJsonWriter implements JsonWriter {

    private static final Logger log = LoggerFactory.getLogger(JacksonJsonWriter.class);

    private final Writer writer;

    private JsonGenerator generator;

    JacksonJsonWriter(Writer writer) {
        this.writer = writer;
        try {
            generator = new JsonFactory().createJsonGenerator(this.writer);
            generator.writeStartObject();
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }

    }


    @Override
    public void addCustomerInformation(String id) {
        try {
            generator.writeStringField(Fields.ID, id);
            generator.writeStringField(Fields.EMAIL, Cart.DEFAULT_CUSTOMER_EMAIL);
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }

    }

    @Override
    public void addProducts(Cart cart) {
        try {
            generator.writeArrayFieldStart(Fields.PRODUCTS);
            writeCartProducts(cart);
            generator.writeEndArray();
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }

    }

    private void writeCartProducts(Cart cart) throws IOException {
        if (null != cart && null != cart.getProducts()) {

            for (Map.Entry<String, PurchaseProduct> next : cart.getProducts().entrySet()) {
                PurchaseProduct n = next.getValue();
                generator.writeStartObject();
                generator.writeStringField(Fields.ProductFields.CODE, "SKU" + next.getKey());
                generator.writeNumberField(Fields.ProductFields.QUANTITY, n.getTotalCount());
                generator.writeNumberField(Fields.ProductFields.TOTALITEMCOST, n.getTotalCost());
                generator.writeEndObject();
            }
        }
    }

    @Override
    public String generate() {
        String json = "{}";
        try {
            generator.writeEndObject();
            generator.flush();
            json = writer.toString();
        } catch (IOException e) {
            log.error("{}", e.getMessage());

        }
        return json;
    }
}


