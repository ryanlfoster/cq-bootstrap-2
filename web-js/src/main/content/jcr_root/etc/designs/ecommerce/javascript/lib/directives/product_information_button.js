(function (ec) {
    'use strict';
    ec.directive('productInfoButton', function () {
        return {
            restrict: 'E',
            scope: {
                product: "=",
                cart: "=cart"
            },
            link: function (scope, element, attrs, controller) {
                element.on('click', function (event) {
                    event.stopPropagation();

                    return false;

                });
            },
            templateUrl: "/etc/designs/ecommerce/templates/productInfoButton.html"
        };
    });


}(ecommerce));
