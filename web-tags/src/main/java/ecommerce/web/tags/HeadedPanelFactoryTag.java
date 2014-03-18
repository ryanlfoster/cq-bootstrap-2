package ecommerce.web.tags;

import ecommerce.domain.HeadedPanel;
import ecommerce.domain.HeadedPanelModel;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HeadedPanelFactoryTag extends SimpleTagSupport {

    public static String MODEL_ATTRIBUTE = "headedpanel.model";


    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().setAttribute("headedpanel", new HeadedPanel(
                getModelInstance()), PageContext.REQUEST_SCOPE);

    }

    private HeadedPanelModel getModelInstance() {
        return ((HeadedPanelModelFactory) getJspContext().findAttribute(MODEL_ATTRIBUTE)).getInstance();
    }
}
