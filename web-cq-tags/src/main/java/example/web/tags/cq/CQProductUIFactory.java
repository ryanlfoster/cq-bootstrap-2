package example.web.tags.cq;

import example.domain.ProductUI;
import example.domain.cq.CQProductUI;
import example.web.tags.ProductUIFactory;
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

