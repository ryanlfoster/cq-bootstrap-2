package ecommerce.domain;

public class HeadedPanel  {


    private HeadedPanelModel model = new NullHeadedPanelModel();

    public HeadedPanel(){}

    public HeadedPanel(HeadedPanelModel model) {
        this.model = model;
    }

    public HeadedPanelModel getModel() {
        return model;
    }

    protected static class NullHeadedPanelModel implements HeadedPanelModel  {

        @Override
        public String getHeaderText() {
            return DEFAULT_HEADER_TEXT;
        }

        @Override
        public String getText() {
            return DEFAULT_TEXT;
        }

    }
}
