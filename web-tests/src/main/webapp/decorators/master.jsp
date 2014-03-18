<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<html lang="en">
<head>
    <title><decorator:title/></title>

    <decorator:head/>

    <jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrahead.jsp"/>

</head>
<body>

<%--<script src="../etc/designs/ecommerce/javascript/deps/angular.js"></script>--%>
<script>
//    var ecommerce = angular.module("ecommerce", []);
</script>

<h1>Master Template</h1>
<div class="container">


    <decorator:body/>

</div>



<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>

</body>
</html>

