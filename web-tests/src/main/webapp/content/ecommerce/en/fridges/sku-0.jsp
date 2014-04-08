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
</div>

</body>
</html>
