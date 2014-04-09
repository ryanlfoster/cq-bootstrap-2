package ecommerce.cart;

public interface CartWriter {

    void addCustomerInformation(String id);

    void addProducts(Cart cart);

    void complete();
}
