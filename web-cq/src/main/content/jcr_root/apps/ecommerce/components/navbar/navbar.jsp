<%@include file="/libs/foundation/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>

<%@ taglib prefix="ecomm-cq" uri="http://www.smithstone.com/ecommerce/cq-tags" %>

<%@ taglib prefix="bootstrap-nav" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/nav" %>

<ecomm-cq:navBarSupportTag/>

<bootstrap-nav:container>

    <bootstrap-nav:header />

    <bootstrap-nav:body>

    </bootstrap-nav:body>


</bootstrap-nav:container>

<ecomm-cq:designModeTag>
    <cq:include path="links" resourceType="foundation/components/parsys"/>
</ecomm-cq:designModeTag>
