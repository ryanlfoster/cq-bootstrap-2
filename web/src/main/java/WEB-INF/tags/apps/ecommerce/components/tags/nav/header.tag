<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>

<%--<%@ attribute name="nav" type="ecommerce.domain.NavBar" required="true" rtexprvalue="true" %>--%>
<bootstrap:navBarFactoryTag/>

<jsp:useBean id="nav" type="ecommerce.domain.NavBar" scope="request"/>


<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#${nav.body.id}">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">${nav.header.brand}</a>
</div>
