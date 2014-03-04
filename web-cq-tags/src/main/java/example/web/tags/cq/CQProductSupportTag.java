package example.web.tags.cq;

import example.web.tags.AbstractProductSupportTag;
import example.web.tags.ProductModelFactory;
import example.web.tags.ProductUIFactory;
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


