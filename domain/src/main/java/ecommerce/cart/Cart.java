package ecommerce.cart;

import ecommerce.domain.Product;
import ecommerce.domain.PurchaseProduct;

import java.util.HashMap;
import java.util.Map;

public abstract class Cart  {

    public final static String DEFAULT_CUSTOMER_EMAIL = "anoncustomer@ecommerce.biz";

    protected abstract void store(Map<String, PurchaseProduct> products);

    public abstract Map<String, PurchaseProduct> getProducts();

    public void add(Product product){
        Map<String, PurchaseProduct> cart = getProducts();
        if(cart == null){
            cart = new HashMap<String, PurchaseProduct>();
        }

        if(cart.containsKey(product.getSku())){
            PurchaseProduct purchaseProduct = cart.get(product.getSku());
            purchaseProduct.add(product);
            cart.put(product.getSku(), purchaseProduct);
        }
        else{
            cart.put(product.getSku(), new PurchaseProduct(product));
        }
        store(cart);
    }


}
