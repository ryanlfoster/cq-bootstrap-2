<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>

<html>
<head>
    <title>Products Page</title>
</head>
<body >

<script>
    (function(){
        ecommerce.products = {
            <ecomm:productsToJsonTag/>
            data : ${productsData}
        };
    })(ecommerce);
</script>

<jsp:include page="/apps/ecommerce/components/templates/product/non-cq/base.jsp"/>
<%--<div id="panel_1" ng-app="ecommerce">--%>
    <%--<jsp:include page="/apps/ecommerce/components/product-tile/non-cq/product-tile.jsp"/>--%>
<%--</div>--%>

</body>
</html>


