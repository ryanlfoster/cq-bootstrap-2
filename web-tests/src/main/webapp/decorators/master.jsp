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

<bootstrap:navBarFactoryTag/>

<jsp:useBean id="nav" type="ecommerce.domain.NavBar" scope="request"/>

<div class="container">

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#${nav.body.id}">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${nav.header.brand}</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="${nav.body.id}">
            <ul class="nav navbar-nav">

                <c:forEach items="${nav.body.links}" var="link">
                    <bootstrap:activeLinkDecorator link="${link}">
                        <li class="${activeLink}"><a href="${link.href}">${link.text}</a></li>
                    </bootstrap:activeLinkDecorator>
                </c:forEach>

            </ul>

        </div>
        <!-- /.nav-collapse -->
    </div><!-- /.container-fluid -->
</nav>




    <decorator:body/>

</div>



<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>

</body>
</html>

