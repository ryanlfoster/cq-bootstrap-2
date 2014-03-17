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
</head>
<body>

    <fsf:productSupportTag/>

    <jsp:include page="/apps/ecommerce/components/ssproduct/non-cq/baseproduct.jsp"/>

</body>
</html>
