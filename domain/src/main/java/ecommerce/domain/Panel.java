package ecommerce.domain;

public class Panel {

    private PanelModel panelModel = new PanelModel() {
        @Override
        public String getText() {
            return "----";
        }
    };

    public Panel(){

    }


    public Panel(PanelModel panelModel) {
        this.panelModel = panelModel;
    }

    public PanelModel getModel() {
        return panelModel;
    }
}
