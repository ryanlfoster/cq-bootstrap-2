package ecommerce.domain.cq;

import ecommerce.domain.HeadedPanelModel;
import org.apache.sling.api.resource.ValueMap;

public class CQHeadedPanelModel implements HeadedPanelModel {

    private final ValueMap properties;

    protected final static String PROPERTY_TEXT = "text";
    protected final static String PROPERTY_HEADER_TEXT = "header";

    public CQHeadedPanelModel(ValueMap properties) {

        this.properties = properties;
    }

    @Override
    public String getHeaderText() {
        return properties.get(PROPERTY_HEADER_TEXT, DEFAULT_HEADER_TEXT);
    }

    @Override
    public String getText() {
        return properties.get(PROPERTY_TEXT , DEFAULT_TEXT);
    }
}
