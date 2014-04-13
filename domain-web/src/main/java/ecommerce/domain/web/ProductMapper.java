package ecommerce.domain.web;

import ecommerce.domain.Product;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

public class ProductMapper {


    public Product parse(Reader reader) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        Product product = new Product();
        try {
            product = objectMapper.readValue(reader, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }
}
