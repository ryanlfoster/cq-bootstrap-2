package ecommerce.components;

import ecommerce.domain.HeadedPanelModel;
import org.jsoup.nodes.Element;

public class HtmlHeadedPanelModel extends HtmlPanelModel implements HeadedPanelModel {

    HtmlHeadedPanelModel(Element element) {
        super(element);
    }


    @Override
    public String getHeaderText() {
        return getElementText(".panel-heading", 0);
    }


}
