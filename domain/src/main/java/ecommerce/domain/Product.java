package ecommerce.domain;

public class Product {

    private ProductModel model;
    private ProductUI ui;

    public Product(ProductModel model, ProductUI ui) {
        this.model = model;
        this.ui = ui;
    }

    public ProductModel getModel() {
        return model;
    }

    public ProductUI getUi() {
        return ui;
    }
}
