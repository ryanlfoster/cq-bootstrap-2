<%--
  Copyright 1997-2008 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================

  Default page portlet component.

  Is used as base for all "page" components. It basically includes the "head"
  and the "body" scripts.

  ==============================================================================

--%><%@page session="false"
            contentType="text/html; charset=utf-8"
            import="com.day.cq.commons.Doctype,
                    com.day.cq.wcm.api.WCMMode,
                    com.day.cq.wcm.foundation.ELEvaluator" %><%
%><%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %><%
%><cq:defineObjects/><%

    // read the redirect target from the 'page properties' and perform the
    // redirect if WCM is disabled.
    String location = properties.get("redirectTarget", "");
    // resolve variables in path
    location = ELEvaluator.evaluate(location, slingRequest, pageContext);
    if (WCMMode.fromRequest(request) == WCMMode.DISABLED && location.length() > 0) {
        // check for recursion
        if (!location.equals(currentPage.getPath())) {
            response.sendRedirect(request.getContextPath() + location + ".html");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return;
    }
    // set doctype
    Doctype.HTML_401_STRICT.toRequest(request);

%><%= Doctype.fromRequest(request).getDeclaration() %>
<html>
<cq:include script="head.portlet.jsp"/>
<cq:include script="body.portlet.jsp"/>
</html>
