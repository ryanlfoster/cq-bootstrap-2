package ecommerce.web.tags.cq;

import ecommerce.domain.NavBarBodyModelUI;
import ecommerce.domain.NavBarHeaderUI;
import ecommerce.domain.NavBarLinkModel;
import ecommerce.web.tags.NavBarFactory;
import ecommerce.web.tags.NavBarFactoryTag;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.testing.sling.MockResource;
import org.apache.sling.testing.resourceresolver.MockResourceResolver;
import org.apache.sling.testing.resourceresolver.MockResourceResolverFactoryOptions;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CQNavBarSupportTagTest {

    @Test
    public void tagExposesNavBarFactoryOnPageScope() throws Exception {

        MockPageContext pageContext = new MockPageContext();

        pageContext.setAttribute("resource" , getMockResource());

        CQNavBarSupportTag tag = new CQNavBarSupportTag();
        tag.setJspContext(pageContext);

        tag.doTag();

        NavBarFactory attribute = (NavBarFactory) pageContext.findAttribute(NavBarFactoryTag.NAV_FACTORY);

        assertThat(attribute, is(notNullValue()));

    }

    @Test
    public void exposedTagShouldHaveBodyConstructedFromResource() throws Exception {


        MockPageContext pageContext = new MockPageContext();

        pageContext.setAttribute("resource" , getMockResource());

        CQNavBarSupportTag tag = new CQNavBarSupportTag();

        tag.setJspContext(pageContext);

        tag.doTag();

        NavBarFactory factory = (NavBarFactory) pageContext.findAttribute(NavBarFactoryTag.NAV_FACTORY);

        NavBarHeaderUI header = factory.getHeaderFactory().getInstance();

        assertThat(header.getBrand(), equalTo("Ecommerce Bootstrap"));
        NavBarBodyModelUI body = factory.getBodyFactory().getInstance();
        assertThat(body.getLinks().size(), equalTo(0));


//        assertLink(body.getLinks().get(0), false, "http://www.google.com.au", "-");
//        assertLink(body.getLinks().get(1), true, "http://www.google.com", "");
//        assertLink(body.getLinks().get(2), false, "http://www.google.co.uk", "");

    }

    private MockResource getMockResource() throws PersistenceException {
        HashMap<String, Map<String, Object>> resources = new HashMap<String, Map<String, Object>>();

        MockResourceResolverFactoryOptions options = new MockResourceResolverFactoryOptions();

        MockResourceResolver resourceResolver = new MockResourceResolver(options, resources);

        MockResource resource = new MockResource(
                resourceResolver,
                "/content/ecommerce/en/jcr:content/par/mycontainer/container_contents/navbar",
                "ecommerce/components/navbar");
        resource.addProperty("brand" , "Ecommerce Bootstrap");


        resourceResolver.create(resource, "links" , new HashMap<String, Object>(){{

            put("sling:resourceType", "foundation/components/parsys");

        }});

        Resource links = resourceResolver.resolve(resource.getPath() + "/links");

        resourceResolver.create(links,
                "link_1", new HashMap<String, Object>() {{
                    put("active", true);
                    put("href", "http://www.google.com");
                    put("sling:resourceType", "ecommerce/components/navbarlink");

                }}
        );
        resourceResolver.create(links,
                "link_2", new HashMap<String, Object>() {{
                    put("active", false);
                    put("href", "http://www.google.co.uk");
                    put("sling:resourceType", "ecommerce/components/navbarlink");
                }}
        );
        resourceResolver.create(links,
                "link_3", new HashMap<String, Object>() {{
                    put("active", false);
                    put("href", "http://www.google.com.au");
                    put("text", "-");
                    put("sling:resourceType", "ecommerce/components/navbarlink");
                }}
        );
        return resource;
    }

    private void assertLink(NavBarLinkModel link, boolean active, String url, String text) {
        assertThat(link.isActive(), equalTo(active));
        assertThat(link.getHref(), equalTo(url));
        assertThat(link.getText(), equalTo(text));
    }


}

