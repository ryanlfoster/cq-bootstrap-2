package ecommerce.domain.cq;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import java.util.HashMap;

public class ValueMapModel {

    protected final ValueMap properties;

    public ValueMapModel(ValueMap properties) {
        this.properties = properties;
    }

    public ValueMapModel() {
        this(new ValueMapDecorator(new HashMap<String, Object>()));
    }
}
