package ecommerce.web.tags.cq;

import org.apache.sling.api.SlingHttpServletRequest;

import javax.servlet.jsp.JspContext;

public class SlingRequestLocator {


    public static final String PAGE_SCOPE_ATTRIBUTE = "slingRequest";

    public static SlingHttpServletRequest locate(JspContext context) {
        Object properties = context.findAttribute(PAGE_SCOPE_ATTRIBUTE);
        return ((SlingHttpServletRequest) properties);
    }
}
