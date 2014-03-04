package example.web.tags.cq;

import example.domain.ProductModel;
import example.web.tags.ProductModelFactory;

public class CQProductModelFactory implements ProductModelFactory {


    public CQProductModelFactory() {

    }

    @Override
    public ProductModel getInstance() {
        return new ProductModel() {
            @Override
            public String getTitle() {
                return "";
            }

            @Override
            public String getDescription() {
                return "";
            }

            @Override
            public String getId() {
                return "";
            }

            @Override
            public String getPrice() {
                return "";
            }

            @Override
            public String getSummary() {
                return "";
            }

            @Override
            public String getCategories() {
                return "";
            }

            @Override
            public String getStockCode() {
                return "";
            }

            @Override
            public String getStockLevel() {
                return null;
            }

            @Override
            public String getFeatures() {
                return "";
            }
        };
    }
}
