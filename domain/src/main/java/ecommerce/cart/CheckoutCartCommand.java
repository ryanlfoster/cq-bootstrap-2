package ecommerce.cart;


public abstract class CheckoutCartCommand implements CartCommand {

    private final CheckoutSuccessResponseWriter success;
    private final CheckoutFailureResponseWriter failure;

    protected CheckoutCartCommand(CheckoutSuccessResponseWriter success, CheckoutFailureResponseWriter failure) {
        this.success = success;
        this.failure = failure;
    }

    @Override
    public void execute() {
        success.success();

    }
}
