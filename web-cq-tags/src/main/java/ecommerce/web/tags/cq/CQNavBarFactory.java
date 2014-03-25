package ecommerce.web.tags.cq;

import ecommerce.domain.NavBar;
import ecommerce.domain.NavBarBodyModelUI;
import ecommerce.domain.NavBarHeaderUI;
import ecommerce.domain.NavBarLinkModel;
import ecommerce.web.tags.NavBarBodyModelUIFactory;
import ecommerce.web.tags.NavBarFactory;
import ecommerce.web.tags.NavBarHeaderUIFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CQNavBarFactory implements NavBarFactory {


    private Resource resource;

    public CQNavBarFactory(Resource resource){

        this.resource = resource;
    }

    @Override
    public NavBarHeaderUIFactory getHeaderFactory() {
        return new NavBarHeaderUIFactory() {
            @Override
            public NavBarHeaderUI getInstance() {
                return new NavBarHeaderUI() {
                    @Override
                    public String getBrand() {
                        return resource.adaptTo(ValueMap.class).get("brand", NavBar.DEFAULT_BRAND);
                    }
                };
            }
        };
    }

    @Override
    public NavBarBodyModelUIFactory getBodyFactory() {
        return new NavBarBodyModelUIFactory() {
            @Override
            public NavBarBodyModelUI getInstance() {
                return new NavBarBodyModelUI() {
                    @Override
                    public List<NavBarLinkModel> getLinks() {

                        List<NavBarLinkModel> links = new ArrayList<NavBarLinkModel>();

                        Iterator<Resource> resourceIterator = resource.listChildren();
                        while (resourceIterator.hasNext()) {
                            final Resource next = resourceIterator.next();
                            final ValueMap properties = next.adaptTo(ValueMap.class);
                            links.add(new NavBarLinkModel() {
                                @Override
                                public boolean isActive() {
                                    return properties.get("active", false);
                                }

                                @Override
                                public String getHref() {
                                    return properties.get("href", "#");
                                }

                                @Override
                                public String getText() {
                                    return properties.get("text" , "");
                                }
                            });
                        }

                        return links;
                    }

                    @Override
                    public String getId() {
                        return "bs-example-navbar-collapse-1";
                    }
                };
            }
        };
    }
}
