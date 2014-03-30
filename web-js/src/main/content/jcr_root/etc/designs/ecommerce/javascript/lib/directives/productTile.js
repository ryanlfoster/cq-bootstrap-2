/*global ecommerce: true */
/*global alert: true */


(function (ecomm) {
    'use strict';
    ecomm.directive('productTile', function (){
        return {
            scope: {
                product: "=product"

            },
            restrict: 'AE',
            templateUrl: '/etc/designs/ecommerce/templates/productTile.html',
            replace : true,


        };
    });
}(ecommerce));


