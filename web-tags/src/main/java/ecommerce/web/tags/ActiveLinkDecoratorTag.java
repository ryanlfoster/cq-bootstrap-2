package ecommerce.web.tags;

import ecommerce.domain.NavBarLinkModel;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ActiveLinkDecoratorTag extends TagSupport {

    private NavBarLinkModel link;

    public void setLink(NavBarLinkModel link) {
        this.link = link;
    }

    @Override
    public int doStartTag() throws JspException {

        if(link.isActive()){
            pageContext.setAttribute("activeLink" , "active");
        }
        else{
            pageContext.setAttribute("activeLink" , "");
        }
        return EVAL_BODY_INCLUDE;
    }


}
