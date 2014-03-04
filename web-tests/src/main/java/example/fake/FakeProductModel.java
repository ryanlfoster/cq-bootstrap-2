package example.fake;

import example.domain.ProductModel;

public class FakeProductModel implements ProductModel {
    @Override
    public String getTitle() {
        return "-- Title --";
    }

    @Override
    public String getDescription() {
        return "-- Description";
    }

    @Override
    public String getId() {
        return "-- ID";
    }

    @Override
    public String getPrice() {
        return "-- 00.00";
    }

    @Override
    public String getSummary() {
        return "-- Summary";
    }

    @Override
    public String getCategories() {
        return "-- Categories";
    }

    @Override
    public String getStockCode() {
        return "-- Stock Code";
    }

    @Override
    public String getStockLevel() {
        return "-- Stock Level";
    }

    @Override
    public String getFeatures() {
        return "-- Features";
    }
}
