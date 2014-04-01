package ecommerce.domain.web;

import ecommerce.domain.Product;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

public class ProductMapper {


    public Product parse(Reader reader) {
        ObjectMapper objectMapper = new ObjectMapper();

        Product product = new Product();
        try {
            product = objectMapper.readValue(reader, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }
}
