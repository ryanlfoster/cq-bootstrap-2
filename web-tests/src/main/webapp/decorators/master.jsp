<%@ page import="ecommerce.domain.NavBar" %>
<%@ page import="ecommerce.domain.NavBarHeaderUI" %>
<%@ page import="ecommerce.fake.FakeNavBarHeaderModel" %>
<%@ page import="ecommerce.fake.FakeNavBarLink" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>
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

<%

    NavBar navBar = new NavBar();
    navBar.setHeader(new FakeNavBarHeaderModel());
    navBar.setLinks(new FakeNavBarLink(true,"#" , "Link 1") , new FakeNavBarLink(false,"#" , "Link 2") , new FakeNavBarLink(false,"#" , "Link 3"));
    request.setAttribute("navbar", navBar);
%>

<jsp:useBean id="navbar" type="ecommerce.domain.NavBar" scope="request"/>

<div class="container">

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${navbar.header.brand}</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <c:forEach items="${navbar.links}" var="link">
                    <ecomm:activeLinkDecorator link="${link}">
                        <li class="${activeLink}"><a href="${link.href}">${link.text}</a></li>
                    </ecomm:activeLinkDecorator>
                </c:forEach>

                <%--<li class="active"><a href="#">Link 1</a></li>--%>
                <%--<li><a href="#">Link 2</a></li>--%>
                <%--<li><a href="#">Link 3</a></li>--%>
<%--
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
--%>
            </ul>

<%--
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
--%>

<%--
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
--%>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>




    <decorator:body/>

</div>



<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>

</body>
</html>

