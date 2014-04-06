package ecommerce.web.tags.cq;

import com.day.cq.wcm.api.WCMMode;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.*;

public class CQDisableInDesignModeTagTest {


    @Test @Ignore("incomplete test currently dont know the solution")
    public void bodyOfTagShouldBeRenderedWhenInDesignMode() throws Exception {

        CQDisableInDesignModeTag tag = new CQDisableInDesignModeTag();

        MockServletContext servletContext = new MockServletContext();

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.setAttribute(WCMMode.REQUEST_ATTRIBUTE_NAME, WCMMode.EDIT);

        MockHttpServletResponse response = new MockHttpServletResponse();


        MockPageContext context = new MockPageContext(servletContext, request , response);


        MockBodyContent fred = new MockBodyContent("fred", response);
        context.pushBody(fred);

        tag.setPageContext(context);

        tag.doStartTag();


    }
}
