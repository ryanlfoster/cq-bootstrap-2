<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="description" required="true" type="java.lang.String" %>
<%@ attribute name="image_src" required="true" type="java.lang.String" %>
<%@ attribute name="cart_quantity" required="true" type="java.lang.String" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="thumbnail product-tile">
    <img data-src="//placekitten.com/g/200/300" alt="" src="${image_src}">

    <div class="caption">
        <h3>${name}</h3>

        <p>${description}</p>

        <p>
            <a href="#" class="btn btn-info" role="button"><span class="glyphicon glyphicon-info-sign"></span>&nbsp; &nbsp;Information</a>
            <a href="#" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;&nbsp;Add To Cart
                <c:if test="${cart_quantity > 0}">
                    &nbsp;<span
                            class="badge">${cart_quantity}</span>
                </c:if>
            </a>

        </p>
    </div>
</div>
