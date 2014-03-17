package ecommerce.fake;

import ecommerce.domain.ProductModel;
import ecommerce.web.tags.ProductModelFactory;

public class FakeProductModelFactory implements ProductModelFactory {

    public ProductModel getInstance() {
        return new FakeProductModel();
    }

}
