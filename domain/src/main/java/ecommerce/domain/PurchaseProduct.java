package ecommerce.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseProduct {

    private List<Product> products = new ArrayList<Product>();

    public PurchaseProduct(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

    public int getTotalCount() {
        return products.size();
    }

    public double getTotalCost() {
        double d = 0.00;
        for (Product product : products) {
            d += product.getCost();
        }
        return d;
    }

    public void add(Product product) {
        products.add(product);
    }
}
