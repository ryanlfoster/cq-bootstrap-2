package ecommerce.web.tags.cq;

import org.apache.sling.api.resource.Resource;

import javax.servlet.jsp.JspContext;

class ResourceLocator {

    public static final String ATTRIBUTE_NAME = "resource";

    static Resource locate(JspContext context){
        return (Resource) context.findAttribute(ATTRIBUTE_NAME);
    }

}
