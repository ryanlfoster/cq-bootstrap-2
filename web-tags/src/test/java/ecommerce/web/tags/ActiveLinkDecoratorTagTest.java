package ecommerce.web.tags;

import ecommerce.domain.NavBarLinkModel;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.JspException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ActiveLinkDecoratorTagTest {


    private NavBarLinkModel link;

    @Test
    public void whenLinkIsNotActiveActiveLinkShouldBeEmptyString() throws Exception {

        link = Mockito.mock(NavBarLinkModel.class);
        Mockito.when(link.isActive()).thenReturn(false);
        assertTag(link, "");
    }

    @Test
    public void whenLinkActiveActiveLinkShouldBeCssClassName() throws Exception {

        link = Mockito.mock(NavBarLinkModel.class);
        Mockito.when(link.isActive()).thenReturn(true);
        assertTag(link, "active");
    }


    private void assertTag(NavBarLinkModel mock, String execpected) throws JspException {
        ActiveLinkDecoratorTag tag = new ActiveLinkDecoratorTag();
        tag.setLink(mock);
        MockPageContext pageContext = new MockPageContext();
        tag.setPageContext(pageContext);
        tag.doStartTag();
        assertThat((String)pageContext.getAttribute("activeLink"), equalTo(execpected));
    }
}
