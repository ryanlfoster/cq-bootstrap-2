package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractHeadedPanelSupportTag;
import ecommerce.web.tags.AbstractPanelSupportTag;
import ecommerce.web.tags.HeadedPanelModelFactory;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQHeadedPanelSupportTag extends AbstractHeadedPanelSupportTag {


    @Override
    protected HeadedPanelModelFactory getModelFactory() {
        ValueMap properties = (ValueMap) getJspContext().findAttribute("properties");
        return new CQHeadedPanelModelFactory(properties);
    }
}
