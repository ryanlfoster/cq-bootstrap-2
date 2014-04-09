<form action="" ng-controller="CheckoutController">

    <div class="panel panel-info" ng-hide="awaitingCheckout">
        <div class="panel-heading">
            <h2>Checkout Status</h2>
        </div>
        <div class="panel-body">
            Checkout Processed ? <b>{{checkoutMessage}}</b>
        </div>
    </div>

    <div class="panel panel-default" ng-hide="!awaitingCheckout">
        <div class="panel-heading">Checkout</div>
        <div class="panel-body">

            <jsp:doBody/>

        </div>
        <div class="panel-footer">
            <button class="btn btn-primary" role="button" ng-click="checkout(customer)">
                <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;Checkout
            </button>
            <button class="btn btn-warning" role="button" ng-click="reset()">
                <span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Reset
            </button>
        </div>
    </div>
</form>
