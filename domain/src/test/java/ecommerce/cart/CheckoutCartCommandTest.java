package ecommerce.cart;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class CheckoutCartCommandTest {

    @Test
    public void successfulCheckoutShouldAskTheSuccessWriterToWriteSuccessAndOrderIdAndComplete() throws Exception {
        CheckoutSuccessResponseWriter s = Mockito.mock(CheckoutSuccessResponseWriter.class);
        CheckoutFailureResponseWriter f = Mockito.mock(CheckoutFailureResponseWriter.class);
        new CheckoutCartCommand(s, f) {

            @Override
            public Cart getCart() {
                return Mockito.mock(Cart.class);
            }
        }.execute();

        Mockito.verify(s, times(1)).success();
    }

    @Test
    public void successfulCheckoutShouldNeverCallFailureWriter() throws Exception {
        CheckoutSuccessResponseWriter s = Mockito.mock(CheckoutSuccessResponseWriter.class);
        CheckoutFailureResponseWriter f = Mockito.mock(CheckoutFailureResponseWriter.class);
        new CheckoutCartCommand(s, f) {

            @Override
            public Cart getCart() {
                return Mockito.mock(Cart.class);
            }
        }.execute();
        Mockito.verify(f, times(0)).failed();
    }
}
