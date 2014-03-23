package ecommerce.fake;

import ecommerce.domain.HeadedPanelModel;
import ecommerce.web.tags.AbstractHeadedPanelSupportTag;
import ecommerce.web.tags.HeadedPanelModelFactory;

public class FakeHeadedPanelSupportTag extends AbstractHeadedPanelSupportTag {

    public static final String TEXT = "Fake Text";
    public static final String HEADER_TEXT = "Fake Header Text";

    @Override
    protected HeadedPanelModelFactory getModelFactory() {
        return new HeadedPanelModelFactory() {
            @Override
            public HeadedPanelModel getInstance() {
                return new HeadedPanelModel() {
                    @Override
                    public String getHeaderText() {
                        return HEADER_TEXT;
                    }

                    @Override
                    public String getText() {
                        return TEXT;
                    }
                };
            }
        };
    }
}
