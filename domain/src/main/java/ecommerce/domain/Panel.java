package ecommerce.domain;

public class Panel {

    private PanelModel panelModel = new NullPanelModel();

    public Panel(){

    }

    public Panel(PanelModel panelModel) {
        this.panelModel = panelModel;
    }

    public PanelModel getModel() {
        return panelModel;
    }

    protected static class NullPanelModel implements PanelModel {

        static interface Default {
            String TEXT = "----";
        }

        @Override
        public String getText() {
            return Default.TEXT;
        }
    }
}
