package ecommerce.fake;

import ecommerce.domain.NavBarBodyModelUI;
import ecommerce.domain.NavBarHeaderUI;
import ecommerce.web.tags.AbstractNavBarSupportTag;
import ecommerce.web.tags.NavBarBodyModelUIFactory;
import ecommerce.web.tags.NavBarFactory;
import ecommerce.web.tags.NavBarHeaderUIFactory;

public class FakeNavBarSupportTag extends AbstractNavBarSupportTag {

    @Override
    protected NavBarFactory getNavBarFactory() {
        return new NavBarFactory() {
            @Override
            public NavBarHeaderUIFactory getHeaderFactory() {
                return new NavBarHeaderUIFactory() {
                    @Override
                    public NavBarHeaderUI getInstance() {
                        return new FakeNavBarHeaderModel();
                    }
                };
            }

            @Override
            public NavBarBodyModelUIFactory getBodyFactory() {
                return new NavBarBodyModelUIFactory() {
                    @Override
                    public NavBarBodyModelUI getInstance() {
                        return new FakeNavBarBody(

                                new FakeNavBarLink(true, "#", "Link 1"),
                                new FakeNavBarLink(false, "#", "Link 2"),
                                new FakeNavBarLink(false, "#", "Link 3")

                        );
                    }
                };
            }
        };
    }
}
