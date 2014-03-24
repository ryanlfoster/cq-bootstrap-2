package ecommerce.domain;

public class NavBar {
    public static final String DEFAULT_BRAND = "Brand";
    private NavBarHeaderUI header;

    public NavBar() {
        header = new NavBarHeaderUI() {
            @Override
            public String getBrand() {
                return DEFAULT_BRAND;
            }
        };
    }

    public NavBarHeaderUI getHeader() {
        return header;
    }

    public void setHeader(NavBarHeaderUI header) {
        this.header = header;
    }
}
