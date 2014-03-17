package ecommerce.fake;

import ecommerce.domain.ProductUI;
import ecommerce.web.tags.ProductUIFactory;

public class FakeProductUIFactory implements ProductUIFactory {

    public ProductUI getInstance() {
        return new FakeProductUI();
    }
}
