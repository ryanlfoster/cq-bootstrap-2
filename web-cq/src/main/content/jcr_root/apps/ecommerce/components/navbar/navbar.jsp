<%@include file="/libs/foundation/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>

<%@ taglib prefix="ecomm-cq" uri="http://www.smithstone.com/ecommerce/cq-tags" %>

<%@ taglib prefix="bootstrap-nav" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/nav" %>

<ecomm-cq:navBarSupportTag/>
<h2>Nav Bar Coming Soon</h2>


<bootstrap-nav:container>

    <bootstrap-nav:header />

    <bootstrap-nav:body>

        <div>
            <p>Links should be dropped here</p>
            <cq:include path="links" resourceType="foundation/components/parsys"/>
        </div>


    </bootstrap-nav:body>


</bootstrap-nav:container>

