package ecommerce.web.tags.cq;

import com.day.cq.wcm.api.WCMMode;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CQDisableInDesignModeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        SlingHttpServletRequest request = SlingRequestLocator.locate(pageContext);

        return areWeInPublishMode(request) ? SKIP_BODY : EVAL_BODY_INCLUDE;
    }

    private boolean areWeInPublishMode(SlingHttpServletRequest request) {
        return WCMMode.DISABLED == WCMMode.fromRequest(request);
    }
}
