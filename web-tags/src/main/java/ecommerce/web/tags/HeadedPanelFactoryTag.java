package ecommerce.web.tags;

import ecommerce.domain.HeadedPanelModel;
import ecommerce.domain.Panel;
import ecommerce.domain.PanelModel;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HeadedPanelFactoryTag extends SimpleTagSupport {

    public static String MODEL_ATTRIBUTE = "headedpanel.model";


    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().setAttribute("headedpanel"  , new Panel(
                getModelInstance()), PageContext.REQUEST_SCOPE);

    }

    private HeadedPanelModel getModelInstance() {
        return ((HeadedPanelModelFactory) getJspContext().findAttribute(MODEL_ATTRIBUTE)).getInstance();
    }
}
