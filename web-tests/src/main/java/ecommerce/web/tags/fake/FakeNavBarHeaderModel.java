package ecommerce.web.tags.fake;

import ecommerce.domain.NavBarHeaderUI;

public class FakeNavBarHeaderModel implements NavBarHeaderUI {

    public static final String NAV_BRAND = "Ecommerce Bootstrap Fake";

    @Override
    public String getBrand() {
        return NAV_BRAND;
    }
}
