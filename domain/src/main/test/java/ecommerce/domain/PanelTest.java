package ecommerce.domain;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PanelTest {

    @org.junit.Test
    public void whenNoModel_ShouldReturnDefaultModel() throws Exception {
        Panel panel = new Panel();
        assertThat(panel, not(nullValue()));
    }
}
