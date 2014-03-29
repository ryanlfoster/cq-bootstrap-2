package ecommerce.web.tags.cq;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.testing.sling.MockResource;
import org.apache.sling.commons.testing.sling.MockResourceResolver;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ResourceLocatorTest {

    @Test
    public void locatedResourceFromPageContext() throws Exception {

        MockPageContext context = new MockPageContext();
        context.setAttribute(ResourceLocator.ATTRIBUTE_NAME , new MockResource(new MockResourceResolver(), "/content", "cq:Page"));

        Resource resource = ResourceLocator.locate(context);

        assertThat(resource.getPath(), equalTo("/content"));
        assertThat(resource.getResourceType(), equalTo("cq:Page"));

    }
}
