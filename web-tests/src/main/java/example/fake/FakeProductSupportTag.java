package example.fake;

import example.web.tags.AbstractProductSupportTag;
import example.web.tags.ProductModelFactory;
import example.web.tags.ProductUIFactory;

public class FakeProductSupportTag extends AbstractProductSupportTag {

    @Override
    protected ProductUIFactory getUIFactory() {
        return new FakeProductUIFactory();
    }

    @Override
    protected ProductModelFactory getModelFactory() {
        return new FakeProductModelFactory();
    }
}

