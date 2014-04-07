/*global ecommerce: true */
/*global alert: true */

(function (ec) {
    'use strict';
    ec.directive('productInformation', function () {
        return {
            restrict: 'E',
            transclude: true,
            replace : true,
            templateUrl: '/etc/designs/ecommerce/templates/productInformation.html'
        };
    });
}(ecommerce));
