package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractPanelSupportTag;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelSupportTag extends AbstractPanelSupportTag {


    private static final String PROPERTIES = "properties";

    @Override
    protected PanelModelFactory getModelFactory() {
        ValueMap properties = (ValueMap) getJspContext().findAttribute(PROPERTIES);
        return new CQPanelModelFactory(properties);
    }
}
