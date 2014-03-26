
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>

<%@ taglib prefix="bootstrap-nav" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/nav" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<bootstrap:navBarFactoryTag/>

<jsp:useBean id="nav" type="ecommerce.domain.NavBar" scope="request"/>

<jsp:doBody/>


<div class="collapse navbar-collapse" id="${nav.body.id}">
    <ul class="nav navbar-nav">

        <%--<c:forEach items="${nav.body.links}" var="link">--%>

            <%--<bootstrap-nav:navlink link="${link}"/>--%>
            <%--<link rel="stylesheet" href="${}"/>--%>
        <%--</c:forEach>--%>


            <li class="active"><a href="#">Text 1</a></li>
            <li><a href="#">Text 2</a></li>
    </ul>

</div>
