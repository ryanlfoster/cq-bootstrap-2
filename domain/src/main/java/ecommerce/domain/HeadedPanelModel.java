package ecommerce.domain;

public interface HeadedPanelModel extends PanelModel {

    String DEFAULT_HEADER_TEXT = "[ Header Text ]";

    String getHeaderText();
}
