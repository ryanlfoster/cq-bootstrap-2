package ecommerce.web.tags.cq;

import ecommerce.web.tags.PanelFactoryTag;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CQPanelSupportTagTest {

    @Test
    public void modelFactoryIsAvailbleOnPageContext() throws Exception {


        MockPageContext context = new MockPageContext();
        ValueMapDecorator valueMap = new ValueMapDecorator(new HashMap<String, Object>());
        context.setAttribute(ValueMapLocator.PAGE_SCOPE_ATTRIBUTE, valueMap);


        CQPanelSupportTag tag = new CQPanelSupportTag();
        tag.setJspContext(context);
        tag.doTag();

        PanelModelFactory attribute = (PanelModelFactory) context.findAttribute(PanelFactoryTag.MODEL_ATTRIBUTE);
        assertThat(attribute.getInstance(), is(notNullValue()));

    }

    @Test
    public void modelFromFactoryHasValuesFromProperties() throws Exception {

        MockPageContext context = new MockPageContext();
        ValueMapDecorator valueMap = new ValueMapDecorator(new HashMap<String, Object>(){{
            put("text" , "Test Text");

        }});
        context.setAttribute(ValueMapLocator.PAGE_SCOPE_ATTRIBUTE, valueMap);


        CQPanelSupportTag tag = new CQPanelSupportTag();
        tag.setJspContext(context);
        tag.doTag();

        PanelModelFactory attribute = (PanelModelFactory) context.findAttribute(PanelFactoryTag.MODEL_ATTRIBUTE);
        assertThat(attribute.getInstance(), is(notNullValue()));


        assertThat(attribute.getInstance().getText(), equalTo("Test Text"));
    }
}
