/*global ecommerce: true */
/*global alert: true, CQ: true */

(function (ecomm) {
    'use strict';
    ecomm.controller('ProductInformationController', ['$scope', function ($scope) {

        $scope.product = ecomm.products.current;

    }]);
}(ecommerce));
