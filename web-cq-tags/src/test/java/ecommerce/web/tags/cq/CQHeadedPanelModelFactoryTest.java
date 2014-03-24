package ecommerce.web.tags.cq;

import ecommerce.domain.HeadedPanel;
import ecommerce.domain.HeadedPanelModel;
import ecommerce.domain.cq.CQHeadedPanelModel;
import ecommerce.web.tags.HeadedPanelFactoryTag;
import ecommerce.web.tags.HeadedPanelModelFactory;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.PageContext;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CQHeadedPanelModelFactoryTest {

    @Test
    public void tag_ShouldReturnModelFactoryThatCanCreateCQHeadedPanelModels() throws Exception {

        PageContext pageContext = new MockPageContext();

        pageContext.setAttribute(ValueMapLocator.PAGE_SCOPE_ATTRIBUTE , new ValueMapDecorator(new HashMap<String, Object>()));
        CQHeadedPanelSupportTag tag = new CQHeadedPanelSupportTag();
        tag.setJspContext(pageContext);
        tag.doTag();

        assertThat(pageContext.findAttribute(HeadedPanelFactoryTag.MODEL_FACTORY_ATTRIBUTE), is(instanceOf(HeadedPanelModelFactory.class)));

        HeadedPanelModelFactory factory = (HeadedPanelModelFactory) pageContext.findAttribute(HeadedPanelFactoryTag.MODEL_FACTORY_ATTRIBUTE);

        assertThat(factory.getInstance(), is(instanceOf(HeadedPanelModel.class)));

    }
}
