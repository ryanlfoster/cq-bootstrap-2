package ecommerce.web.tags.cq;

import ecommerce.domain.HeadedPanel;
import ecommerce.domain.HeadedPanelModel;
import ecommerce.web.tags.HeadedPanelFactoryTag;
import ecommerce.web.tags.HeadedPanelModelFactory;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CQHeadedPanelSupportTagTest {


    @Test
    public void factoryShouldBeOnPageContext() throws Exception {

        CQHeadedPanelSupportTag tag = new CQHeadedPanelSupportTag();

        ValueMapDecorator valueMap = new ValueMapDecorator(new HashMap<String, Object>());

        MockPageContext context = new MockPageContext();

        context.setAttribute(ValueMapLocator.PAGE_SCOPE_ATTRIBUTE, valueMap);

        tag.setJspContext(context);


        tag.doTag();


        HeadedPanelModelFactory attribute = (HeadedPanelModelFactory) context.findAttribute(HeadedPanelFactoryTag.MODEL_FACTORY_ATTRIBUTE);


        assertThat(attribute, is(notNullValue()));

    }

    @Test
    public void modelFromFactoryShouldContainValuesMappedFromValueMap() throws Exception {

        CQHeadedPanelSupportTag tag = new CQHeadedPanelSupportTag();

        ValueMapDecorator valueMap = new ValueMapDecorator(new HashMap<String, Object>(){{
            put("header", "Test Header Text");
            put("text", "Test Text --");

        }});

        MockPageContext context = new MockPageContext();

        context.setAttribute(ValueMapLocator.PAGE_SCOPE_ATTRIBUTE, valueMap);

        tag.setJspContext(context);


        tag.doTag();


        HeadedPanelModelFactory attribute = (HeadedPanelModelFactory) context.findAttribute(HeadedPanelFactoryTag.MODEL_FACTORY_ATTRIBUTE);

        HeadedPanelModel instance = attribute.getInstance();

        assertThat(instance.getHeaderText(), equalTo("Test Header Text"));
        assertThat(instance.getText(), equalTo("Test Text --"));
    }


}
