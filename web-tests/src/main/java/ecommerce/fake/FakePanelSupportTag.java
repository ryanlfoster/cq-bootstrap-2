package ecommerce.fake;

import ecommerce.domain.PanelModel;
import ecommerce.web.tags.AbstractPanelSupportTag;
import ecommerce.web.tags.PanelModelFactory;

public class FakePanelSupportTag extends AbstractPanelSupportTag {

    @Override
    protected PanelModelFactory getModelFactory() {
        return new PanelModelFactory() {
            @Override
            public PanelModel getInstance() {
                return new PanelModel() {
                    @Override
                    public String getText() {
                        return "Fake Text ";
                    }
                };
            }
        };
    }
}
