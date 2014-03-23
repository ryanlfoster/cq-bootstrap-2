package ecommerce.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HeadedPanelTest {


    @Test
    public void whenNoModel_ShouldReturnDefaultModel() throws Exception {

        HeadedPanel panel = new HeadedPanel();
        assertThat(panel.getModel(), is(notNullValue()));
        assertThat(panel.getModel().getHeaderText(), equalTo(HeadedPanel.NullHeadedPanelModel.Defaults.HEADER_TEXT));
        assertThat(panel.getModel().getText(), equalTo(HeadedPanel.NullHeadedPanelModel.Defaults.TEXT));

    }

    @Test
    public void whenModelIsProvided_ShouldReturnModel() throws Exception {

        final String text = "Fake Text";
        final String header = "Fake Header";

        HeadedPanelModel model = new HeadedPanelModel() {
            @Override
            public String getHeaderText() {
                return header;
            }

            @Override
            public String getText() {

                return text;
            }

        };
        HeadedPanel panel = new HeadedPanel(model);
        assertThat(panel.getModel(), is(notNullValue()));
        assertThat(panel.getModel().getHeaderText(), equalTo(header));
        assertThat(panel.getModel().getText(), equalTo(text));

    }
}
