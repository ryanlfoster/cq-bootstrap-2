<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>

<!doctype html>
<html lang="en">
<head>
    <title>Product 0 Information</title>
</head>
<body>

<script>

    (function (ec) {
        <ecomm:productToJsonTag/>

        ec.products.current = ${productData};

    }(ecommerce));

</script>


<div ng-app="ecommerce">

    <product-information></product-information>

    <%--<div ng-controller="CartController">
        <div ng-controller="ProductInformationController">

            <div class="panel panel-default">
                <div class="panel-heading">
                    {{product.name}}  <span class="badge">{{product.quantity}}</span>
                </div>
                <div class="panel-body">
                    <div><p>{{product.code}}</p></div>
                    <div><p>{{product.sku}}</p></div>
                    <div><p>{{product.description}}</p></div>
                    <img src="" alt="" ng-src="{{product.image}}"/>

                    <div>

                    </div>
                </div>
                <div class="panel-footer">
                    <cart-button product="product" cart="cart"></cart-button>
                </div>
            </div>
        </div>
    </div>--%>

</div>

</body>
</html>
