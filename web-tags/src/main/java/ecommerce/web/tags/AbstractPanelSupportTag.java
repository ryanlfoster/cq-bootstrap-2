package ecommerce.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public abstract class AbstractPanelSupportTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().setAttribute(PanelFactoryTag.MODEL_ATTRIBUTE, getModelFactory(), PageContext.REQUEST_SCOPE);
    }

    abstract protected PanelModelFactory getModelFactory();
}
