package ecommerce.web.tags;

import ecommerce.domain.Product;
import ecommerce.domain.web.ProductJsonGenerator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class ProductToJsonTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().setAttribute("productData",
                new ProductJsonGenerator(new StringWriter()).writeProductJson(getProduct())
        );
    }

    protected Product getProduct() {
        return new Product("Product Information #",
                getLoremIpsum(),
                "//placekitten.com/340/300",
                String.valueOf(1), 10.00);
    }

    private String getLoremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!";
    }
}


