package ecommerce.domain.web;

import com.jayway.jsonassert.JsonAssert;
import ecommerce.domain.Product;
import org.codehaus.jackson.JsonGenerator;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProductJsonGeneratorTest {

    @Test
    public void exceptionsShouldBeSwallowedAndReturnEmptyString() throws Exception {

        Writer writer = Mockito.mock(Writer.class);

        ProductJsonGenerator generator = new ProductJsonGenerator(writer){
            @Override
            public void writeProduct(JsonGenerator generator, Product product) throws IOException {
                throw new IOException("Fake IOException");
            }
        };

        String json = generator.writeProductsJson(new Product());

        assertThat(json, equalTo(""));

    }

    @Test
    public void productsShouldBeMappedToJson() throws Exception {

        Product product = new Product("Name", "Desc", "imge", "01", 0.00);
        Product product1 = new Product("Name 1", "Desc 1", "imge 1", "02", 0.00);
        StringWriter sw = new StringWriter();
        String json = new ProductJsonGenerator(sw).writeProductsJson(product, product1);



        JsonAssert.with(json).assertThat("$.[0].name", equalTo("Name"));
        JsonAssert.with(json).assertThat("$.[0].description", equalTo("Desc"));
        JsonAssert.with(json).assertThat("$.[0].image", equalTo("imge"));
        JsonAssert.with(json).assertThat("$.[0].code", equalTo("01"));

        JsonAssert.with(json).assertThat("$.[1].name", equalTo("Name 1"));
        JsonAssert.with(json).assertThat("$.[1].description", equalTo("Desc 1"));
        JsonAssert.with(json).assertThat("$.[1].image", equalTo("imge 1"));
        JsonAssert.with(json).assertThat("$.[1].code", equalTo("02"));
    }

    @Test
    public void productShouldBeMappedToJson() throws Exception {

        Product product = new Product("Name", "Desc", "imge", "01", 0.00);
        StringWriter sw = new StringWriter();
        String json = new ProductJsonGenerator(sw).writeProductJson(product);

        JsonAssert.with(json).assertThat("$.name", equalTo("Name"));
        JsonAssert.with(json).assertThat("$.description", equalTo("Desc"));
        JsonAssert.with(json).assertThat("$.image", equalTo("imge"));
        JsonAssert.with(json).assertThat("$.code", equalTo("01"));

    }
}
