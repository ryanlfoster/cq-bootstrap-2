package ecommerce.web.tags.cq;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.PageContext;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ValueMapLocatorTest {


    @Test
    public void whenPropertiesIsNotAvailableOnPageReturnEmptyMap() throws Exception {

        MockPageContext context = new MockPageContext();
        ValueMap locate = ValueMapLocator.locate(context);
        assertNotNull(locate);
    }

    @Test
    public void whenPropertiesAvailbleTHenReturn() throws Exception {
        MockPageContext context = new MockPageContext();
        ValueMapDecorator properties = new ValueMapDecorator(new HashMap<String, Object>(){{put("prop" , "value");}});
        context.setAttribute("properties", properties, PageContext.PAGE_SCOPE);
        ValueMap located = ValueMapLocator.locate(context);
        assertThat(properties, equalTo(located));
        assertThat(located.get("prop", String.class), equalTo("value"));
    }
}
