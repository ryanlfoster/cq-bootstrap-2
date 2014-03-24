package ecommerce.domain.cq;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import java.util.HashMap;

class ValueMapModel {

    protected final ValueMap properties;

    ValueMapModel(ValueMap properties) {
        this.properties = properties;
    }

    ValueMapModel() {
        this(new ValueMapDecorator(new HashMap<String, Object>()));
    }
}
