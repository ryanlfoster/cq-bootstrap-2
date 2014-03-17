package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractProductSupportTag;
import ecommerce.web.tags.ProductModelFactory;
import ecommerce.web.tags.ProductUIFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQProductSupportTag extends AbstractProductSupportTag {

    @Override
    protected ProductUIFactory getUIFactory() {
        return new CQProductUIFactory((ValueMap) getJspContext().findAttribute("properties"));
    }

    @Override
    protected ProductModelFactory getModelFactory() {
        return new CQProductModelFactory();
    }


}


