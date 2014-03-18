<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags" %>
<%@ taglib prefix="fsf" uri="http://www.smithstone.com/ecommerce/fake-tags" %>
<%@taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>

<html>
<head>
    <title>Product Test</title>


    <%--<style>
        .clear_fix { clear:both; }
        .product-info { border:1px solid black; width : 300px; }
        .product-info div.attribute { clear:right ;}
        .product-info div.title { float: left; }
        .product-info div.data { float:right; }
    </style>--%>

    <%--<link rel="stylesheet" href="../etc/designs/ecommerce/style/main.css"/>--%>
</head>
<body >


<ecomm:panelFactory/>

    <%--<fsf:productSupportTag/>--%>

    <%--<jsp:include page="/apps/ecommerce/components/ssproduct/non-cq/baseproduct.jsp"/>--%>


    <t:container>

        <h1>Hello World</h1>


        <jsp:include page="/apps/ecommerce/components/panelwithheader/non-cq/basepanel.jsp"/>

        <jsp:include page="/apps/ecommerce/components/tabpanel/non-cq/basepanel.jsp"/>

        <jsp:include page="/apps/ecommerce/components/panelwithheader/non-cq/basepanel.jsp"/>

    </t:container>



    <%--<script src="../etc/designs/ecommerce/javascript/lib/controllers/greeting_controller.js"></script>--%>
    <%--<script src="../etc/designs/ecommerce/javascript/lib/controllers/login_controller.js"></script>--%>

</body>
</html>
