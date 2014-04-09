<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib prefix="ecommerce-cart" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/cart" %>
<!doctype html>
<html lang="en">
<head>
    <title>Ecommerce Checkout</title>


    <style>

    </style>
</head>
<body>

<div class="container" ng-app="ecommerce">
    <ecommerce-cart:checkout>


        <jsp:include page="/apps/ecommerce/components/cart/checkout/billing/non-cq/base.jsp"/>
        <jsp:include page="/apps/ecommerce/components/cart/checkout/shipping/non-cq/base.jsp"/>
        <jsp:include page="/apps/ecommerce/components/cart/checkout/payment/non-cq/base.jsp"/>

    </ecommerce-cart:checkout>
</div>


</body>
</html>
