package ecommerce.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavBar {
    public static final String DEFAULT_BRAND = "Brand";
    private NavBarHeaderUI header;
    private List<NavBarLinkModel> links;

    public NavBar() {
        header = new NavBarHeaderUI() {
            @Override
            public String getBrand() {
                return DEFAULT_BRAND;
            }
        };
        links = new ArrayList<NavBarLinkModel>();

    }

    public NavBarHeaderUI getHeader() {
        return header;
    }

    public void setHeader(NavBarHeaderUI header) {
        this.header = header;
    }

    public void setLinks(NavBarLinkModel... link) {
        links.addAll(Arrays.asList(link));
    }

    public List<NavBarLinkModel> getLinks() {
        return links;
    }
}
