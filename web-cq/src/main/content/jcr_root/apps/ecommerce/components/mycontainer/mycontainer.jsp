<%@include file="/libs/foundation/global.jsp" %>

<%@page session="false" import="com.day.cq.wcm.foundation.Paragraph,
com.day.cq.wcm.foundation.ParagraphSystem" %>


<div class="mycontainer container" style="min-height:100px; padding:1em ; border:1px dashed grey">
    <h1>My Container</h1>


    <div style="">
        <cq:include path="container_contents" resourceType="foundation/components/parsys"/>

    </div>
<%--

    <%
        ParagraphSystem parSys = ParagraphSystem.create(resource, slingRequest);
        for (Paragraph par: parSys.paragraphs()) {
            request.setAttribute("par" , par);
            %>
        <cq:include path="${par.path}" resourceType="${par.resourceType}"/>
    <%
        }
    %>
--%>

</div>

