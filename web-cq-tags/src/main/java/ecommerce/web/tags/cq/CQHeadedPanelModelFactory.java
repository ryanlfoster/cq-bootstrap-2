package ecommerce.web.tags.cq;

import ecommerce.domain.HeadedPanelModel;
import ecommerce.web.tags.HeadedPanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQHeadedPanelModelFactory implements HeadedPanelModelFactory {


    private ValueMap properties;

    public CQHeadedPanelModelFactory(ValueMap properties) {

        this.properties = properties;
    }

    @Override
    public HeadedPanelModel getInstance() {
        return new HeadedPanelModel() {
            @Override
            public String getHeaderText() {
                return properties.get("header" , "[ No Header Text ]");
            }

            @Override
            public String getText() {
                return properties.get("text" , "[ No Text ]");
            }
        };
    }
}
