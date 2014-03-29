package ecommerce.fake;

import ecommerce.domain.NavBarBodyModelUI;
import ecommerce.domain.NavBarLinkModel;

import java.util.Arrays;
import java.util.List;

public class FakeNavBarBody implements NavBarBodyModelUI {

    private List<NavBarLinkModel> links;

    public FakeNavBarBody(NavBarLinkModel ... links) {
        this.links = Arrays.asList(links);
    }

    @Override
    public List<NavBarLinkModel> getLinks() {
        return links;
    }

    @Override
    public String getId() {
        return "bs-example-navbar-collapse-1";
    }
}
