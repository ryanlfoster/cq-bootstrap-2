<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ecomm-fake" uri="http://www.smithstone.com/ecommerce/fake-tags" %>
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>


<%@ taglib prefix="bootstrap-nav" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/nav" %>

<!doctype html>
<html lang="en">
<head>
    <title><decorator:title/></title>


    <jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrahead.jsp"/>
    <decorator:head/>



    <style>
        body {

        }
    </style>

</head>
<body>

<ecomm-fake:navBarSupportTag/>


<div class="container">



    <bootstrap-nav:container>

        <bootstrap-nav:header />

        <bootstrap-nav:body/>

    </bootstrap-nav:container>


    <decorator:body/>

</div>




<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>






</body>
</html>

