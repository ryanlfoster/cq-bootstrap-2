package ecommerce.domain.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CartFormatter;
import ecommerce.domain.PurchaseProduct;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class CartJsonFormatter implements CartFormatter {


    public String format(Cart cart, String id){
        JsonGenerator jsonGenerator;
        try {
            StringWriter writer1 = new StringWriter();
            jsonGenerator = new JsonFactory().createJsonGenerator(writer1);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField(Fields.ID, Integer.valueOf(id));
            jsonGenerator.writeStringField(Fields.EMAIL , Cart.DEFAULT_CUSTOMER_EMAIL);
            jsonGenerator.writeArrayFieldStart(Fields.PRODUCTS);


            if( null != cart && null != cart.getProducts()){

                for (Map.Entry<String, PurchaseProduct> next : cart.getProducts().entrySet()) {
                    PurchaseProduct n = next.getValue();
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField(Fields.ProductFields.CODE, "SKU" + next.getKey());
                    jsonGenerator.writeNumberField(Fields.ProductFields.QUANTITY, n.getTotalCount());
                    jsonGenerator.writeNumberField(Fields.ProductFields.TOTALITEMCOST, n.getTotalCost() );
                    jsonGenerator.writeEndObject();
                }
            }

            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
            jsonGenerator.flush();
            return writer1.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("{ id : %s , email : %s , products : [] }", "-" , "-");
    }
}
