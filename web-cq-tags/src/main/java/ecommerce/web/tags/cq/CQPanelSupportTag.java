package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractPanelSupportTag;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelSupportTag extends AbstractPanelSupportTag {


    @Override
    protected PanelModelFactory getModelFactory() {
        ValueMap properties = (ValueMap) getJspContext().findAttribute("properties");
        return new CQPanelModelFactory(properties);
    }
}
