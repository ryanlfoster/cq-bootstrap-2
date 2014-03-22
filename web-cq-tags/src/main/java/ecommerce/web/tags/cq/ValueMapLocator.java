package ecommerce.web.tags.cq;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import javax.servlet.jsp.JspContext;
import java.util.HashMap;

public class ValueMapLocator {

    public static ValueMap locate(JspContext context) {
        Object properties = context.findAttribute("properties");
        if(properties == null) {
            return new ValueMapDecorator(new HashMap<String, Object>());
        }
        return ((ValueMap) properties);
    }
}
