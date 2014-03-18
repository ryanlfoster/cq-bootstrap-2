package ecommerce.web.tags.cq;

import ecommerce.domain.PanelModel;
import ecommerce.domain.cq.CQPanelModel;
import ecommerce.web.tags.PanelModelFactory;
import org.apache.sling.api.resource.ValueMap;

public class CQPanelModelFactory implements PanelModelFactory {


    private ValueMap properties;

    public CQPanelModelFactory(ValueMap properties) {

        this.properties = properties;
    }

    @Override
    public PanelModel getInstance() {

        return new CQPanelModel(properties);

/*
        return new PanelModel() {
            @Override
            public String getText() {
                return "CQ Panel Text [ Should Be Read From Repo ]";
            }
        };
*/
    }
}
