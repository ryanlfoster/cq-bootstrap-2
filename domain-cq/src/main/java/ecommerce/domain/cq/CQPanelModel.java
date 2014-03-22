package ecommerce.domain.cq;

import ecommerce.domain.PanelModel;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelModel implements PanelModel {


    public static interface Properties {

        String TEXT = "text";
    }

    private ValueMap properties;

    public CQPanelModel(ValueMap properties) {

        this.properties = properties;
    }

    public CQPanelModel() {
    }

    @Override
    public String getText() {
        return properties.get(Properties.TEXT, DEFAULT_TEXT);
    }
}
