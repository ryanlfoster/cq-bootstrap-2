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

        if(cart.containsKey(product.getCode())){
            PurchaseProduct purchaseProduct = cart.get(product.getCode());
            purchaseProduct.add(product);
            cart.put(product.getCode(), purchaseProduct);
        }
        else{
            cart.put(product.getCode(), new PurchaseProduct(product));
        }
        store(cart);
    }


}
