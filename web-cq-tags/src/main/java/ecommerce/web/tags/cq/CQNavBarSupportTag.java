package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractNavBarSupportTag;
import ecommerce.web.tags.NavBarFactory;
import org.apache.sling.api.resource.Resource;

public class CQNavBarSupportTag extends AbstractNavBarSupportTag {

    @Override
    protected NavBarFactory getNavBarFactory() {
        Resource resource = (Resource) getJspContext().findAttribute("resource");
        return new CQNavBarFactory(resource.getResourceResolver().resolve(resource.getPath() + "/jcr:content/par/navbar"));
    }
}
