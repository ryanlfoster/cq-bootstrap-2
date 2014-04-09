package ecommerce.domain.web;

import com.jayway.jsonassert.JsonAssert;
import ecommerce.domain.Product;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProductJsonGeneratorTest {

    @Test
    public void productsShouldBeMappedToJson() throws Exception {

        Product product = new Product("Name", "Desc", "imge", "01", 0.00);
        Product product1 = new Product("Name 1", "Desc 1", "imge 1", "02", 0.00);
        String json = ProductJsonGenerator.writeJson(product, product1);


        JsonAssert.with(json).assertThat("$.[0].name", equalTo("Name"));
        JsonAssert.with(json).assertThat("$.[0].description", equalTo("Desc"));
        JsonAssert.with(json).assertThat("$.[0].image", equalTo("imge"));
        JsonAssert.with(json).assertThat("$.[0].code", equalTo("01"));
        JsonAssert.with(json).assertThat("$.[0].sku", equalTo("01"));
        JsonAssert.with(json).assertThat("$.[0].quantity", equalTo(0));

        JsonAssert.with(json).assertThat("$.[1].name", equalTo("Name 1"));
        JsonAssert.with(json).assertThat("$.[1].description", equalTo("Desc 1"));
        JsonAssert.with(json).assertThat("$.[1].image", equalTo("imge 1"));
        JsonAssert.with(json).assertThat("$.[1].code", equalTo("02"));
        JsonAssert.with(json).assertThat("$.[1].sku", equalTo("02"));
        JsonAssert.with(json).assertThat("$.[1].quantity", equalTo(0));
    }

    @Test
    public void productShouldBeMappedToJson() throws Exception {

        Product product = new Product("Name", "Desc", "imge", "01", 0.00);
        String json = ProductJsonGenerator.writeJson(product);

        JsonAssert.with(json).assertThat("$.name", equalTo("Name"));
        JsonAssert.with(json).assertThat("$.description", equalTo("Desc"));
        JsonAssert.with(json).assertThat("$.image", equalTo("imge"));
        JsonAssert.with(json).assertThat("$.code", equalTo("01"));
        JsonAssert.with(json).assertThat("$.sku", equalTo("01"));
        JsonAssert.with(json).assertThat("$.quantity", equalTo(0));

    }
}
