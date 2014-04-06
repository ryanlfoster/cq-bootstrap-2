<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>
<ecomm:headedPanelFactory/>
<jsp:useBean id="headedpanel" type="ecommerce.domain.HeadedPanel" scope="request"/>


<headed-panel header-text="${headedpanel.model.headerText}"
              body-text="${headedpanel.model.text}"></headed-panel>
