/*global ecommerce: true */

(function (ec) {
    'use strict';
    ec.directive('cartButton', function () {
        return {
            restrict: 'E',
            scope : {
                product : "=",
                cart : "="
            },
            controller: function ($scope, CartService) {
                $scope.m = function () {

                    CartService.add($scope.product, $scope.cart).then(function () {
                        CartService.getData($scope.cart);
                    });
                    CartService.getData($scope.cart);
                };
            },
            link: function (scope, element, attrs, controller) {
                element.on('click', function (event) {
                    event.stopPropagation();
                    scope.m();
                    return false;
                });
            },
            templateUrl: "/etc/designs/ecommerce/templates/cartButton.html"
        };
    });

}(ecommerce));
