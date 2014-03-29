package ecommerce.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavBar {
    public static final String DEFAULT_BRAND = "Brand";
    private NavBarHeaderUI header;
    private List<NavBarLinkModel> links;

    private NavBarBodyModelUI body;


    public NavBar() {
        header = new NavBarHeaderUI() {
            @Override
            public String getBrand() {
                return DEFAULT_BRAND;
            }
        };
        links = new ArrayList<NavBarLinkModel>();

    }

    public NavBar(NavBarBodyModelUI body, NavBarHeaderUI header) {
        this.body = body;
        this.header = header;
    }

    public NavBarHeaderUI getHeader() {
        return header;
    }

    public NavBarBodyModelUI getBody() {
        return body;
    }

    public void setBody(NavBarBodyModelUI body) {
        this.body = body;
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
