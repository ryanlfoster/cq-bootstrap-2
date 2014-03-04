package example.fake;

import example.domain.ProductUI;

public class FakeProductUI implements ProductUI {
    @Override
    public String getStockLevelLabel() {
        return "Stock Level Lbl";
    }

    @Override
    public String getStockCodeLabel() {
        return "Stock Code Lbl";
    }

    @Override
    public String getCategoriesLabel() {
        return "Categories Lbl";
    }

    @Override
    public String getSummaryLabel() {
        return "Summary Lbl";
    }

    @Override
    public String getPriceLabel() {
        return "Price Lbl";
    }

    @Override
    public String getDescriptionLabel() {
        return "Description Lbl";
    }

    @Override
    public String getTitleLabel() {
        return "Title Lbl";
    }

    @Override
    public String getIdLabel() {
        return "ID Lbl";
    }

    @Override
    public String getFeaturesLabel() {
        return "Features Lbl";
    }
}
