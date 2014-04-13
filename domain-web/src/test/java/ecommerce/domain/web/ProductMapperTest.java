package ecommerce.domain.web;

import ecommerce.domain.Product;
import org.junit.Test;

import java.io.StringReader;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProductMapperTest {


    @Test
    public void parseProductJson() throws Exception {

        String payload = "{ \"code\":\"1\",\"name\":\"Product Information #\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!\",\"image\":\"//placekitten.com/340/300\",\"quantity\":1}";
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.parse(new StringReader(payload));
        assertThat(product.getCode(), equalTo("1"));
        assertThat(product.getName(), equalTo("Product Information #"));
        assertThat(product.getDescription(), equalTo("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!"));
    }
}
