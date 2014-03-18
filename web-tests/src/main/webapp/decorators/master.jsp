<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<html lang="en">
<head>
    <title><decorator:title/></title>

    <decorator:head/>

    <jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrahead.jsp"/>

    <style>
        body {

            margin-top: 60px;
        }
    </style>

</head>
<body>



<div class="container">


    <decorator:body/>

</div>



<jsp:include page="/apps/ecommerce/components/templates/master/non-cq/extrabody.jsp"/>

</body>
</html>

