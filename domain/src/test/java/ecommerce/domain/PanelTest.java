package ecommerce.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PanelTest {

    @org.junit.Test
    public void whenNoModel_ShouldReturnDefaultModel() throws Exception {
        Panel panel = new Panel();
        assertThat(panel, not(nullValue()));
        assertThat(panel.getModel().getText(), equalTo(Panel.NullPanelModel.Default.TEXT));
    }

    @Test
    public void whenModelIsProvidedShouldReturnModel() throws Exception {

        final String modelText = "Inline model text";
        final PanelModel model = new PanelModel() {

            @Override
            public String getText() {
                return modelText;
            }

        };

        Panel panel = new Panel(model);
        assertThat(panel.getModel().getText(), equalTo(modelText));


    }
}
