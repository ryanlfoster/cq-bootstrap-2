/*global ecommerce: true */

(function (ecomm) {
    'use strict';
    ecomm.directive('shippingInformation', function (){
        return {

            restrict: 'E',
            templateUrl: '/etc/designs/ecommerce/templates/shippingInformation.html',
            replace : true
        };
    });
}(ecommerce));
