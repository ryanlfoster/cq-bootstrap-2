package ecommerce.fake;

import ecommerce.domain.NavBarHeaderUI;

public class FakeNavBarHeaderModel implements NavBarHeaderUI {
    @Override
    public String getBrand() {
        return " Ecommerce Bootstrap Fake";
    }
}
