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

    private static final Logger log = LoggerFactory.getLogger(JsonCartWriter.class);
    private JsonGenerator generator;

    public JsonCartWriter(final Writer writer) {

        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator = new JsonFactory().createJsonGenerator(writer);
            }
        });
    }

    @Override
    public void write(String id, Cart cart) {
        start();
        addCustomerInformation(id);
        addProducts(cart);
        complete();
    }

    private void start() {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeStartObject();
            }
        });
    }

    private void addCustomerInformation(final String id) {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeStringField(Fields.ID, id);
                generator.writeStringField(Fields.EMAIL, Cart.DEFAULT_CUSTOMER_EMAIL);
            }
        });

    }

    private void addProducts(final Cart cart) {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeArrayFieldStart(Fields.PRODUCTS);
                writeCartProducts(cart);
                generator.writeEndArray();
            }
        });

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

    private void complete() {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeEndObject();
                generator.flush();
                generator.close();
            }
        });
    }

    private void performIOCommand(IOCommand command) {
        try {
            command.execute();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private interface IOCommand {
        void execute() throws IOException;
    }

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


}
