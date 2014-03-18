package ecommerce.web.tags;

import ecommerce.domain.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PanelFactoryTag extends SimpleTagSupport {


    public static String MODEL_ATTRIBUTE = "panel.model";


    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().setAttribute("panel"  , new Panel(
                getModelInstance()), PageContext.REQUEST_SCOPE);

    }

    private PanelModel getModelInstance() {
        return ((PanelModelFactory) getJspContext().findAttribute(MODEL_ATTRIBUTE)).getInstance();
    }
}
