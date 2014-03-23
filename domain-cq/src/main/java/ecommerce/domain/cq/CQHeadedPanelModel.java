package ecommerce.domain.cq;

import ecommerce.domain.HeadedPanelModel;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import java.util.HashMap;

public class CQHeadedPanelModel extends ValueMapModel implements HeadedPanelModel {

    protected final static String PROPERTY_TEXT = "text";
    protected final static String PROPERTY_HEADER_TEXT = "header";

    public CQHeadedPanelModel(ValueMap properties) {
        super(properties);
    }

    public CQHeadedPanelModel() {
        super();
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

