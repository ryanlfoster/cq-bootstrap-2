<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>
<ecomm:panelFactory/>
<jsp:useBean id="panel" type="ecommerce.domain.Panel" scope="request"/>

<panel body-text="${panel.model.text}"></panel>

