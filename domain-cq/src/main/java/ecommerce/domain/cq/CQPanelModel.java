package ecommerce.domain.cq;

import ecommerce.domain.PanelModel;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import java.util.HashMap;

public class CQPanelModel extends ValueMapModel implements PanelModel {

    public CQPanelModel(ValueMap properties) {
        super(properties);
    }

    public CQPanelModel() {
        super();
    }

    @Override
    public String getText() {
        return properties.get(Properties.TEXT, DEFAULT_TEXT);
    }

    public static interface Properties {

        String TEXT = "text";
    }
}
