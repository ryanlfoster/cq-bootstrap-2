package ecommerce.cart;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.Writer;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;

public class ViewCartCommandTest {

    @Test
    public void expectionsShouldBeLogged() throws Exception {

        final Writer mock = Mockito.mock(Writer.class);

        Mockito.doThrow(new IOException("fake io exception")).when(mock).write(anyString());

        final Cart cart = Mockito.mock(Cart.class);

        ViewCartCommand command = getViewCartCommand(mock, cart);

        command.execute();
        Mockito.verify(mock, never()).close();
        Mockito.verify(mock, never()).flush();

    }

    @Test
    public void formatterResponseIsWrittenToWritterAndFlushed() throws Exception {
        final Writer mock = Mockito.mock(Writer.class);
        final Cart cart = Mockito.mock(Cart.class);
        ViewCartCommand command = getViewCartCommand(mock, cart);

        command.execute();

        Mockito.verify(mock).write("fake formatted");
        Mockito.verify(mock).close();
        Mockito.verify(mock).flush();
    }

    private ViewCartCommand getViewCartCommand(final Writer mock, final Cart cart) {
        return new ViewCartCommand() {
            @Override
            protected Writer getWriter() {
                return mock;
            }

            @Override
            protected CartFormatter getFormatter() {
                CartFormatter cartFormatter = Mockito.mock(CartFormatter.class);
                Mockito.when(cartFormatter.format(cart, "1")).thenReturn("fake formatted");
                return cartFormatter;
            }

            @Override
            protected String getId() {
                return "1";
            }

            @Override
            public Cart getCart() {
                return cart;
            }
        };
    }
}
