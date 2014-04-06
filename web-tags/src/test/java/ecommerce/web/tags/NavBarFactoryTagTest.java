package ecommerce.web.tags;

import ecommerce.domain.NavBar;
import ecommerce.domain.NavBarBodyModelUI;
import ecommerce.domain.NavBarHeaderUI;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockPageContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;


public class NavBarFactoryTagTest {

    @Test
    public void navBarFactoryTagShouldConstructNavBarUsingFactoriesProvidedByAFactoryInPageContext() throws Exception {

        final NavBarHeaderUIFactory headerUIFactory = Mockito.mock(NavBarHeaderUIFactory.class);

        Mockito.when(headerUIFactory.getInstance()).thenReturn(Mockito.mock(NavBarHeaderUI.class));


        final NavBarBodyModelUIFactory bodyModelUIFactory = Mockito.mock(NavBarBodyModelUIFactory.class);
        Mockito.when(bodyModelUIFactory.getInstance()).thenReturn(Mockito.mock(NavBarBodyModelUI.class));

        MockPageContext pageContext = new MockPageContext();

        NavBarFactory navBarFactory = Mockito.mock(NavBarFactory.class);
        Mockito.when(navBarFactory.getBodyFactory()).thenReturn(bodyModelUIFactory);
        Mockito.when(navBarFactory.getHeaderFactory()).thenReturn(headerUIFactory);

        pageContext.setAttribute(NavBarFactoryTag.NAV_FACTORY, navBarFactory);

        NavBarFactoryTag tag = new NavBarFactoryTag();
        tag.setJspContext(pageContext);
        tag.doTag();

        Object attribute = pageContext.findAttribute(NavBarFactoryTag.NAVBAR);
        assertThat(attribute, is(notNullValue()));

        assertThat(attribute, is(instanceOf(NavBar.class)));

        assertThat(((NavBar) attribute).getBody(), is(notNullValue()));
        assertThat((((NavBar) attribute).getHeader()), is(notNullValue()));

    }
}


