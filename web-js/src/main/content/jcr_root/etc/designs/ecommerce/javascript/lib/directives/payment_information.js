/*global ecommerce: true */

(function (ecomm) {
    'use strict';
    ecomm.directive('paymentInformation', function (){
        return {

            restrict: 'E',
            templateUrl: '/etc/designs/ecommerce/templates/paymentInformation.html',
            replace : true
        };
    });
}(ecommerce));
