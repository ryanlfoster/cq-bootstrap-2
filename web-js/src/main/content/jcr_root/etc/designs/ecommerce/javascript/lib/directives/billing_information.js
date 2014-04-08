/*global ecommerce: true */

(function (ecomm) {
    'use strict';
    ecomm.directive('billingInformation', function (){
        return {

            restrict: 'E',
            templateUrl: '/etc/designs/ecommerce/templates/billingInformation.html',
            replace : true
        };
    });
}(ecommerce));
