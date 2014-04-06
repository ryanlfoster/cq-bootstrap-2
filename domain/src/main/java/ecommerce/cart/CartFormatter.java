package ecommerce.cart;

public interface CartFormatter {

    public String format(Cart cart, String id);

    interface Fields {

        static String ID = "id";
        static String EMAIL = "email";
        static String PRODUCTS = "products";

        interface ProductFields {
            static String CODE = "code";
            static String QUANTITY = "quantity";
            static String TOTALITEMCOST = "totalItemCost";
        }
    }
}
