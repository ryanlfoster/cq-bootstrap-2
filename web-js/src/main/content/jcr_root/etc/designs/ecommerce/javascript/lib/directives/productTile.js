/*global ecommerce: true */
/*global alert: true */

(function (ec) {
    'use strict';
    ec.directive('productTile', function(){
        return {
            restrict: 'E',
            transclude: true,
            scope: {
                product: "=",
                cart : "="
            },
            replace : true ,
            templateUrl: '/etc/designs/ecommerce/templates/product.html'
        };
    });
}(ecommerce));


