package ecommerce.domain;

public class HeadedPanel  {


    private HeadedPanelModel model = new HeadedPanelModel() {
        @Override
        public String getHeaderText() {
            return "[ Header Text ]";
        }

        @Override
        public String getText() {
            return "[ ---- ]";
        }

        public String toString() {
            return String.format("%s - %s", getHeaderText(), getModel());
        }
    };

    public HeadedPanel(){}

    public HeadedPanel(HeadedPanelModel model) {
        this.model = model;
    }

    public HeadedPanelModel getModel() {
        return model;
    }
}
