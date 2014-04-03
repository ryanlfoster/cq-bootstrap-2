<div ng-app="ecommerce">

    <div class="container" ng-controller="CartController">

        <div class="row">
            <div class="panel panel-info">
                <div class="panel-heading">Cart Information</div>

                <table class="table">
                    <tbody>
                    <tr ng-repeat="product in cart.products">
                        <td>{{product.code}}</td>
                        <td>{{product.quantity}}</td>
                        <td>{{product.totalItemCost}}</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td align="right" colspan="3" style="font-weight: bold">
                            {{totalCost()}}
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>

        </div>


        <div ng-controller="ProductsController">
            <div class="row ">
                <div ng-repeat="product in products">
                    <product-tile product="product" cart="cart"></product-tile>
                </div>
            </div>
        </div>
    </div>


</div>
