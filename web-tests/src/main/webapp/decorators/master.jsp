<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="ecomm-fake" uri="http://www.smithstone.com/ecommerce/fake-tags" %>
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>
<!doctype html>
<html lang="en">
<head>
    <title><decorator:title/></title>

    <decorator:head/>

    <jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrahead.jsp"/>

    <style>
        body {

        }
    </style>

</head>
<body>

<ecomm-fake:navBarSupportTag/>



<div class="container">

    <jsp:include page="/apps/ecommerce/components/navbar/non-cq/base.jsp"/>    


    <decorator:body/>

</div>


<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>

</body>
</html>

