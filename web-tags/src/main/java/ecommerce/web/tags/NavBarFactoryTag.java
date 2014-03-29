package ecommerce.web.tags;

import ecommerce.domain.NavBar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class NavBarFactoryTag extends SimpleTagSupport {

    public static final String NAVBAR = "nav";
    public static final String NAV_FACTORY = "nav.factory";


    @Override
    public void doTag() throws JspException, IOException {
        NavBarFactory factory = (NavBarFactory) getJspContext().findAttribute(NAV_FACTORY);
        NavBarHeaderUIFactory headerUIFactory = factory.getHeaderFactory();
        NavBarBodyModelUIFactory bodyModelUIFactory = factory.getBodyFactory();
        getJspContext().setAttribute(NAVBAR,
                new NavBar(bodyModelUIFactory.getInstance(), headerUIFactory.getInstance()),
                PageContext.REQUEST_SCOPE);
    }


}
