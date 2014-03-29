package ecommerce.web.tags.cq;

import ecommerce.web.tags.AbstractPanelSupportTag;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelSupportTag extends AbstractPanelSupportTag {

    @Override
    protected PanelModelFactory getModelFactory() {
        return new CQPanelModelFactory(ValueMapLocator.locate(getJspContext()));
    }
}
