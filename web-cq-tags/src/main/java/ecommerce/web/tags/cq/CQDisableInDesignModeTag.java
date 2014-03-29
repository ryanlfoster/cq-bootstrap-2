package ecommerce.web.tags.cq;

import com.day.cq.wcm.api.WCMMode;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CQDisableInDesignModeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        return areWeInPublishMode(this.pageContext.getRequest()) ? SKIP_BODY : EVAL_BODY_INCLUDE;
    }

    private boolean areWeInPublishMode(ServletRequest request) {
        return WCMMode.DISABLED == WCMMode.fromRequest(request);
    }
}
