package ecommerce.cart.web.output;

import ecommerce.cart.CheckoutFailureResponseWriter;
import ecommerce.cart.CheckoutResponseWriter;
import ecommerce.cart.CheckoutSuccessResponseWriter;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

public class JsonCheckoutResponseWriter implements CheckoutResponseWriter, CheckoutSuccessResponseWriter, CheckoutFailureResponseWriter {

    private static final Logger log = LoggerFactory.getLogger(JsonCheckoutResponseWriter.class);
    public static final String ORDER_ID = "orderId";
    public static final String SUCCESS = "success";



    private JsonGenerator generator;

    public JsonCheckoutResponseWriter(final Writer writer) {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator = new JsonFactory().createJsonGenerator(writer);
            }
        });
    }

    private void start() {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeStartObject();
            }
        });
    }

    @Override
    public void failed() {
        start();
        writeFailure();
        complete();
    }

    @Override
    public void success(){
        start();
        writeOrderId();
        writeSuccess();
        complete();
    }

    @Override
    public void writeOrderId() {
        if (null != generator) {
            performIOCommand(new IOCommand() {
                @Override
                public void execute() throws IOException {
                    generator.writeStringField(ORDER_ID, "OrderId#" + Math.random() * Byte.MAX_VALUE);

                }
            });
        }
    }

    @Override
    public void complete() {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeEndObject();
                generator.flush();
            }
        });
    }

    @Override
    public void writeSuccess() {
        if (null != generator) {
        performIOCommand(new IOCommand() {
            @Override
            public void execute() throws IOException {
                generator.writeBooleanField(SUCCESS, true);
            }
        });
        }
    }

    @Override
    public void writeFailure() {
        if (null != generator) {
            performIOCommand(new IOCommand() {
                @Override
                public void execute() throws IOException {
                    generator.writeBooleanField(SUCCESS, false);
                }
            });
        }
    }

    private void performIOCommand(IOCommand command) {
        try {
            command.execute();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private interface IOCommand {
        void execute() throws IOException;
    }

}

