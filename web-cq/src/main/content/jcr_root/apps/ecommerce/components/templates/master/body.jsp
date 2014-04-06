<%@include file="/libs/foundation/global.jsp" %>
<div ng-app="ecommerce">
    <cq:include resourceType="foundation/components/parsys" path="par"/>
    <cq:include script="extrabody.jsp"/>

<%--
        <div ng-controller="CartController">

            <div>
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
                        <tfooter>
                            <tr>
                                <td align="right" colspan="3" style="bold">
                                    {{totalCost()}}
                                </td>
                            </tr>
                        </tfooter>
                    </table>
                </div>

            </div>


            <div ng-controller="ProductsController">
                <div class="row">
                    <div ng-repeat="product in products">
                        <product-tile product="product" cart="cart"></product-tile>
                    </div>
                </div>
            </div>
        </div>
--%>


</div>


