package ecommerce.web.tags;

import ecommerce.domain.Product;
import ecommerce.domain.web.ProductJsonGenerator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductsToJsonTag extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        List<Product> products = new ArrayList<Product>();
        for(int i = 0 ; i < (3 * 15) ; i++) {
            products.add(getProduct(i));
        }
        getJspContext().setAttribute("productsData",
                new ProductJsonGenerator(new StringWriter()).writeProductsJson(products.toArray(new Product[products.size()])));
    }

    protected Product getProduct(int sku) {

        return new Product("Product Information #",
                 getLoremIpsum(),
                 "//placekitten.com/340/300",
                 String.valueOf(sku), 10.00);
    }



    private String getLoremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!";
    }
}



