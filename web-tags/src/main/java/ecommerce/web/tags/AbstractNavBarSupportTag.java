package ecommerce.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public abstract class AbstractNavBarSupportTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().setAttribute(NavBarFactoryTag.NAV_FACTORY,
                getNavBarFactory(),
                PageContext.REQUEST_SCOPE
        );
    }

    protected abstract NavBarFactory getNavBarFactory();
}
