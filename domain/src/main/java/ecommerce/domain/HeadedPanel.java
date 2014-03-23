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
            return Defaults.HEADER_TEXT;
        }

        @Override
        public String getText() {
            return Defaults.TEXT;
        }

        public interface Defaults {
            String HEADER_TEXT = "[ Header Text ]";
            String TEXT = "[ ---- ]";
        }
    }
}
