package ecommerce.fake;

import ecommerce.web.tags.AbstractProductSupportTag;
import ecommerce.web.tags.ProductModelFactory;
import ecommerce.web.tags.ProductUIFactory;

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

