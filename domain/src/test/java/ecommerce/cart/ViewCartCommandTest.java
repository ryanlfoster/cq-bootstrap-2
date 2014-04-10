package ecommerce.cart;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.Writer;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;

public class ViewCartCommandTest {


    @Test
    public void formatterResponseIsWrittenToWritterAndFlushed() throws Exception {

        final CartWriter writer = Mockito.mock(CartWriter.class);

        final Cart cart = Mockito.mock(Cart.class);

        new ViewCartCommand(writer) {
            @Override
            protected String getId() {
                return "1";
            }

            @Override
            public Cart getCart() {
                return cart;
            }
        }.execute();

        Mockito.verify(writer).write("1" , cart);
    }

}
