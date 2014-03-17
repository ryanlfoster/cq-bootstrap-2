<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fsf" uri="http://www.smithstone.com/ecommerce/fake-tags" %>
<html>
<head>
    <title>Product Test</title>


    <style>
        .clear_fix { clear:both; }
        .product-info { border:1px solid black; width : 300px; }
        .product-info div.attribute { clear:right ;}
        .product-info div.title { float: left; }
        .product-info div.data { float:right; }
    </style>

    <link rel="stylesheet" href="../etc/designs/ecommerce/style/main.css"/>
</head>
<body >



    <fsf:productSupportTag/>

    <jsp:include page="/apps/ecommerce/components/ssproduct/non-cq/baseproduct.jsp"/>



    <script src="../etc/designs/ecommerce/javascript/lib/controllers/greeting_controller.js"></script>
    <script src="../etc/designs/ecommerce/javascript/lib/controllers/login_controller.js"></script>

</body>
</html>
