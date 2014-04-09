package ecommerce.cart.web.output;

import ecommerce.cart.Cart;
import ecommerce.cart.CartWriter;
import ecommerce.domain.PurchaseProduct;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class JsonCartWriter implements CartWriter {

    private Writer writer;

    interface Fields {

        static String ID = "id";
        static String EMAIL = "email";
        static String PRODUCTS = "products";

        interface ProductFields {
            static String CODE = "code";
            static String QUANTITY = "quantity";
            static String TOTAL_ITEM_COST = "totalItemCost";
        }
    }

    private static final Logger log = LoggerFactory.getLogger(JsonCartWriter.class);

    private JsonGenerator generator;

    public JsonCartWriter(Writer writer) {
        this.writer = writer;

        try {


            generator = new JsonFactory().createJsonGenerator(this.writer);
            generator.writeStartObject();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }


    @Override
    public void addCustomerInformation(String id) {
        try {
            generator.writeStringField(Fields.ID, id);
            generator.writeStringField(Fields.EMAIL, Cart.DEFAULT_CUSTOMER_EMAIL);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void addProducts(Cart cart) {
        try {
            generator.writeArrayFieldStart(Fields.PRODUCTS);
            writeCartProducts(cart);
            generator.writeEndArray();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    private void writeCartProducts(Cart cart) throws IOException {
        if (null != cart && null != cart.getProducts()) {

            for (Map.Entry<String, PurchaseProduct> next : cart.getProducts().entrySet()) {
                PurchaseProduct n = next.getValue();
                generator.writeStartObject();
                generator.writeStringField(Fields.ProductFields.CODE, "SKU" + next.getKey());
                generator.writeNumberField(Fields.ProductFields.QUANTITY, n.getTotalCount());
                generator.writeNumberField(Fields.ProductFields.TOTAL_ITEM_COST, n.getTotalCost());
                generator.writeEndObject();
            }
        }
    }


    @Override
    public void complete() {
        try {
            generator.writeEndObject();
            generator.flush();
            generator.close();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
