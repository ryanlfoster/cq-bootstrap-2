package ecommerce.web.tags.cq;

import org.apache.sling.api.SlingHttpServletRequest;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockPageContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SlingRequestLocatorTest {

    @Test
    public void testxxx() throws Exception {

        SlingHttpServletRequest request = Mockito.mock(SlingHttpServletRequest.class);

        MockPageContext pageContext = new MockPageContext();

        pageContext.setAttribute("slingRequest", request);

        assertThat(SlingRequestLocator.locate(pageContext), equalTo(request));

    }
}
