<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>
<%@ taglib prefix="bootstrap-nav" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/nav" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<bootstrap:navBarFactoryTag/>

<jsp:useBean id="nav" type="ecommerce.domain.NavBar" scope="request"/>

<bootstrap-nav:container>

    <bootstrap-nav:header />

    <bootstrap-nav:body/>

</bootstrap-nav:container>

