package ecommerce.domain.cq;

import ecommerce.domain.PanelModel;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelModel implements PanelModel {

    private ValueMap properties;

    public CQPanelModel(ValueMap properties) {

        this.properties = properties;
    }

    public CQPanelModel() {
    }

    @Override
    public String getText() {
        return properties.get("text" , "[ No Text Specified ]");
    }
}
