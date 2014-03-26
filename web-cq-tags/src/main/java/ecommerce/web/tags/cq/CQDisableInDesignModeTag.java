package ecommerce.web.tags.cq;

import com.day.cq.wcm.api.WCMMode;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CQDisableInDesignModeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {


        SlingHttpServletRequest request = (SlingHttpServletRequest) pageContext.findAttribute("slingRequest");

        WCMMode wcmMode = WCMMode.fromRequest(request);

        if(WCMMode.DISABLED == wcmMode)
            return SKIP_BODY;

        return EVAL_BODY_INCLUDE;
    }
}
