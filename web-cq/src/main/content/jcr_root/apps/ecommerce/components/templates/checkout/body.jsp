<%@include file="/libs/foundation/global.jsp" %>
<%@taglib prefix="ecomm-checkout" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/cart" %>

<cq:include script="non-cq/base.jsp"/>

<div ng-app="ecommerce" class="container">



    <ecomm-checkout:checkout>

        <cq:include path="par" resourceType="foundation/components/parsys"/>

    </ecomm-checkout:checkout>

</div>


