package ecommerce.domain.web;

import ecommerce.cart.Cart;
import ecommerce.cart.CartFormatter;
import ecommerce.domain.PurchaseProduct;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.Map;

public class CartJsonFormatter implements CartFormatter {


    public String format(Cart cart, String id){
        JsonGenerator jsonGenerator;
        try {
            StringWriter writer1 = new StringWriter();
            jsonGenerator = new JsonFactory().createJsonGenerator(writer1);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", id);
            jsonGenerator.writeStringField("email" , "ssmithstone@me.com");


            jsonGenerator.writeArrayFieldStart("products");


            if( null != cart && null != cart.getProducts()){

                for (Map.Entry<String, PurchaseProduct> next : cart.getProducts().entrySet()) {
                    PurchaseProduct n = next.getValue();
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("code", "SKU" + next.getKey());
                    jsonGenerator.writeNumberField("quantity", n.getTotalCount());
                    jsonGenerator.writeNumberField("totalItemCost", n.getTotalCost() );
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
