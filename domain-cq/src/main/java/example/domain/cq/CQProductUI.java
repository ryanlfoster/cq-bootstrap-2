package example.domain.cq;

import example.domain.ProductUI;
import org.apache.sling.api.resource.ValueMap;

public class CQProductUI implements ProductUI {

    private ValueMap properties;

    public CQProductUI(ValueMap properties) {
        this.properties = properties;
    }

    @Override
    public String getStockLevelLabel() {
        return properties.get("stockLevelLabel" , "Stock Level");
    }

    @Override
    public String getStockCodeLabel() {
        return properties.get("stockCodeLabel" , "Stock Code");
    }

    @Override
    public String getCategoriesLabel() {
        return properties.get("stockLevelLabel" , "Stock Level");
    }

    @Override
    public String getSummaryLabel() {
        return properties.get("summaryLabel" , "Summary");
    }

    @Override
    public String getPriceLabel() {
        return properties.get("priceLabel" , "Price");
    }

    @Override
    public String getDescriptionLabel() {
        return properties.get("descriptionLabel" , "Description");
    }

    @Override
    public String getTitleLabel() {
        return properties.get("titleLabel" , "Title");
    }

    @Override
    public String getIdLabel() {
        return properties.get("idLabel" , "ID");
    }

    @Override
    public String getFeaturesLabel() {
        return properties.get("featuresLabel" , "Features");
    }


}
