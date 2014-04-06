package ecommerce.web.tags.cq;

import ecommerce.domain.HeadedPanelModel;
import ecommerce.domain.cq.CQHeadedPanelModel;
import ecommerce.web.tags.HeadedPanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQHeadedPanelModelFactory implements HeadedPanelModelFactory {


    private ValueMap properties;

    public CQHeadedPanelModelFactory(ValueMap properties) {

        this.properties = properties;
    }

    @Override
    public HeadedPanelModel getInstance() {
        return new CQHeadedPanelModel(properties);
    }
}
