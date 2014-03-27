
<%@ taglib prefix="bootstrap" uri="http://www.smithstone.com/ecommerce/tags" %>
<%@ attribute name="link" type="ecommerce.domain.NavBarLinkModel" required="true" rtexprvalue="true" %>

<bootstrap:activeLinkDecorator link="${link}">
    <li class="${activeLink}"><a href="${link.href}">${link.text}</a></li>
</bootstrap:activeLinkDecorator>
