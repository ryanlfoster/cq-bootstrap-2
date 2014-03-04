package example.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public abstract class AbstractProductSupportTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().setAttribute(ProductFactoryTag.MODEL_ATTRIBUTE, getModelFactory(), PageContext.REQUEST_SCOPE);
        getJspContext().setAttribute(ProductFactoryTag.UI_ATTRIBUTE, getUIFactory(), PageContext.REQUEST_SCOPE);
    }

    abstract protected ProductUIFactory getUIFactory();

    abstract protected ProductModelFactory getModelFactory();
}
