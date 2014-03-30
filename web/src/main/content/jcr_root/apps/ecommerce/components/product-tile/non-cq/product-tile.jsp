<%--<%@ taglib prefix="ecomm-product" tagdir="/WEB-INF/tags/apps/ecommerce/components/tags/product" %>--%>
<%--
<div class="col-sm-6 col-md-4">

    <ecomm-product:tile name="Product Information"
                        description="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda
                consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur
                quae sequi soluta unde voluptas!"
                        image_src="//placekitten.com/340/300"
                        cart_quantity="0"/>

</div>
--%>

<div ng-controller="ProductsController">
    <div class="row">
            <span ng-repeat="product in products">
                <product-tile product="product"></product-tile>
            </span>
    </div>
</div>
