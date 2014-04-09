package ecommerce.web.tags;

import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ProductsToJsonTagTest {


    @Test
    public void productJsonIsAvailableOnPageContext() throws Exception {

        ProductsToJsonTag tag = new ProductsToJsonTag();
        MockPageContext pageContext = new MockPageContext();
        tag.setJspContext(pageContext);
        tag.doTag();
        assertThat(pageContext.findAttribute("productsData"), not(nullValue()));

    }
}
