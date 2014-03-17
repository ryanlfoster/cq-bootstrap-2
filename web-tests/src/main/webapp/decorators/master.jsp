<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<html>
<head>
    <title><decorator:title/></title>
    <decorator:head/>
</head>
<body>

<script src="../etc/designs/ecommerce/javascript/deps/angular.js"></script>
<script>
    var ecommerce = angular.module("ecommerce", []);
</script>
<decorator:body/>



</body>
</html>

