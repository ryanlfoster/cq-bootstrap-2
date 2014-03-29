package ecommerce.web.tags.cq;

import com.day.cq.wcm.api.WCMMode;
import org.junit.Test;
import org.springframework.mock.web.*;

public class CQDisableInDesignModeTagTest {


    @Test
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

//        tag.doAfterBody();

//        tag.doEndTag();

//        String contentAsString = response.getContentLength();
        //
//        context.getOut().println("Lo");
        System.out.println("Content = " + response.getContentAsString() );

    }
}
