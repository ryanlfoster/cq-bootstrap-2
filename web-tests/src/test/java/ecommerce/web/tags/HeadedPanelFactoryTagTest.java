package ecommerce.web.tags;

import ecommerce.domain.HeadedPanel;
import ecommerce.domain.HeadedPanelModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.PageContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HeadedPanelFactoryTagTest {

    AbstractHeadedPanelSupportTag factoryTag;

    PageContext pageContext = new MockPageContext();
    private HeadedPanelModel fakeModel;

    @Before
    public void initFactoryTag() throws Exception {

        fakeModel = new HeadedPanelModel() {
            @Override
            public String getHeaderText() {
                return "Fake Header Text";
            }

            @Override
            public String getText() {
                return "Fake Text";
            }
        };

        final HeadedPanelModelFactory factory = new HeadedPanelModelFactory() {
            @Override
            public HeadedPanelModel getInstance() {
                return fakeModel;
            }
        };


        factoryTag = new AbstractHeadedPanelSupportTag(){
            @Override
            protected HeadedPanelModelFactory getModelFactory() {
                return factory;
            }
        };

    }

    @Test
    public void supportTagConfigured_WhenFactoryTagIsInvoice_ShouldPutModelInPageContext() throws Exception {

        factoryTag.setJspContext(pageContext);
        factoryTag.doTag();

        HeadedPanelFactoryTag tag = new HeadedPanelFactoryTag();
        tag.setJspContext(pageContext);
        tag.doTag();

        assertThat(pageContext.findAttribute(HeadedPanelFactoryTag.HEADED_PANEL), is(notNullValue()));
        assertThat(((HeadedPanel) pageContext.findAttribute(HeadedPanelFactoryTag.HEADED_PANEL)).getModel(), equalTo(fakeModel));

    }
}
