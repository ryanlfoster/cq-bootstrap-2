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

    private JsonGenerator generator;

    public JsonCheckoutResponseWriter(Writer writer) {
        try {
            generator = new JsonFactory().createJsonGenerator(writer);
            generator.writeStartObject();
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }

    }

    public void failed(){
        writeFailure();
        complete();
    }

    public void success(){
        writeOrderId();
        writeSuccess();
        complete();
    }

    @Override
    public void writeOrderId() {
        if (null != generator) {
            try {
                generator.writeStringField("orderId", "OrderId#" + Math.random() * Byte.MAX_VALUE);
            } catch (IOException e) {
                log.error("{}", e.getMessage());
            }
        }
    }

    @Override
    public void complete() {
        try {
            generator.writeEndObject();
            generator.flush();
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }
    }

    @Override
    public void writeSuccess() {
        if (null != generator) {
            try {
                generator.writeBooleanField("success", true);
            } catch (IOException e) {
                log.error("{}", e.getMessage());
            }
        }
    }

    @Override
    public void writeFailure() {
        if (null != generator) {
            try {
                generator.writeBooleanField("success", false);
            } catch (IOException e) {
                log.error("{}", e.getMessage());
            }
        }
    }

}
