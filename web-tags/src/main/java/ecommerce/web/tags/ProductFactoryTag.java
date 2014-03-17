package ecommerce.web.tags;

import ecommerce.domain.Product;
import ecommerce.domain.ProductModel;
import ecommerce.domain.ProductUI;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ProductFactoryTag extends SimpleTagSupport {

    public static String UI_ATTRIBUTE = "product.ui";
    public static String MODEL_ATTRIBUTE = "product.model";


    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().setAttribute("product"  , new Product(
                getModelInstance(),
                getUIInstance()), PageContext.REQUEST_SCOPE);

    }

    private ProductUI getUIInstance() {
        return ((ProductUIFactory) getJspContext().findAttribute(UI_ATTRIBUTE)).getInstance();
    }

    private ProductModel getModelInstance() {
        return ((ProductModelFactory) getJspContext().findAttribute(MODEL_ATTRIBUTE)).getInstance();
    }


}
