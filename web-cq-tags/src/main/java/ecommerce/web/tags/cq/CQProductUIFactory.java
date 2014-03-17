package ecommerce.web.tags.cq;

import ecommerce.domain.ProductUI;
import ecommerce.domain.cq.CQProductUI;
import ecommerce.web.tags.ProductUIFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQProductUIFactory implements ProductUIFactory {

    private ValueMap properties;

    public CQProductUIFactory(ValueMap properties) {

        this.properties = properties;
    }

    @Override
    public ProductUI getInstance() {
        return new CQProductUI(properties);
    }


}

