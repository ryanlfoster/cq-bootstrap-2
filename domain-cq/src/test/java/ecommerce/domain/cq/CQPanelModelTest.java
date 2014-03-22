package ecommerce.domain.cq;

import ecommerce.domain.PanelModel;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CQPanelModelTest {

    private HashMap<String, Object> hashMap;
    private CQPanelModel model;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap<String, Object>();
        model = new CQPanelModel(new ValueMapDecorator(hashMap));
    }

    @Test
    public void whenNoTextIsAvailable_ShouldReturnACodedDefault() throws Exception {
        assertThat(model.getText(), equalTo(PanelModel.DEFAULT_TEXT));
    }

    @Test
    public void whenTextIsAvailable_ShouldReturnIt() throws Exception {
        hashMap.put(CQPanelModel.Properties.TEXT, "Test Text");
        assertThat(model.getText(), equalTo("Test Text"));

    }
}
