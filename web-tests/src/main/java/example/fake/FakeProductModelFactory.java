package example.fake;

import example.domain.ProductModel;
import example.web.tags.ProductModelFactory;

public class FakeProductModelFactory implements ProductModelFactory {

    public ProductModel getInstance() {
        return new FakeProductModel();
    }

}
