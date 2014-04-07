package ecommerce.web.tags;

import org.codehaus.jackson.JsonGenerator;

import java.io.IOException;

class ProductJsonGenerator {

    public static void writeJson(JsonGenerator generator , Product product){
        try {
            generator.writeStartObject();
            generator.writeStringField("code", product.getCode());
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
