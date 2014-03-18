<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>
<ecomm:headedPanelFactory/>
<jsp:useBean id="headedpanel" type="ecommerce.domain.HeadedPanel" scope="request"/>
<div class="panel panel-default">
    <div class="panel-heading">
        ${headedpanel.model.headerText}
    </div>
    <div class="panel-body">
        ${headedpanel.model.text}
    </div>
</div>
