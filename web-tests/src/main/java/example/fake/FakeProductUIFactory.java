package example.fake;

import example.domain.ProductUI;
import example.web.tags.ProductUIFactory;

public class FakeProductUIFactory implements ProductUIFactory {

    public ProductUI getInstance() {
        return new FakeProductUI();
    }
}
