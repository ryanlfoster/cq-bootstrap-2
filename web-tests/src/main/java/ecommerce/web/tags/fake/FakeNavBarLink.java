package ecommerce.web.tags.fake;

import ecommerce.domain.NavBarLinkModel;

public class FakeNavBarLink implements NavBarLinkModel {

    private boolean active;
    private final String href;
    private final String text;

    public FakeNavBarLink(boolean active, String href , String text) {
        this.active = active;
        this.href = href;
        this.text = text;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public String getText() {
        return text;
    }
}
