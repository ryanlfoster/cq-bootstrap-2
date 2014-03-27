package ecommerce.domain.cq;

import ecommerce.domain.HeadedPanelModel;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CQHeadedPanelModelTest {


    @Test
    public void model_ShouldReturnDefaultsWhenNotAvailableInValueMap() throws Exception {

        ValueMapDecorator properties = new ValueMapDecorator(new HashMap<String, Object>());
        CQHeadedPanelModel model = new CQHeadedPanelModel(properties);
        assertThat(model.getHeaderText(), equalTo(HeadedPanelModel.DEFAULT_HEADER_TEXT));
        assertThat(model.getText(), equalTo(HeadedPanelModel.DEFAULT_TEXT));
    }

    @Test
    public void modelHasNoValueProvided_ShouldReturnDefaultValues() throws Exception {
        CQHeadedPanelModel model = new CQHeadedPanelModel();
        assertThat(model.getHeaderText(), equalTo(HeadedPanelModel.DEFAULT_HEADER_TEXT));
        assertThat(model.getText(), equalTo(HeadedPanelModel.DEFAULT_TEXT));

    }

    @Test
    public void model_ShouldReturnPropertyValuesWhenAvailabeInValueMap() throws Exception {
        HashMap<String, Object> base = new HashMap<String, Object>();
        ValueMapDecorator properties = new ValueMapDecorator(base);
        String text = "CQ_TEXT";
        String header = "CQ_HEADER";
        base.put(CQHeadedPanelModel.PROPERTY_TEXT, text);
        base.put(CQHeadedPanelModel.PROPERTY_HEADER_TEXT, header);
        CQHeadedPanelModel model = new CQHeadedPanelModel(properties);
        assertThat(model.getHeaderText(), equalTo(header));
        assertThat(model.getText(), equalTo(text));
    }
}

