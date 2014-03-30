/*global ecommerce: true */
/*global alert: true, CQ: true */


(function (ecomm) {
    'use strict';
    ecomm.controller('ProductsController', ['$scope', function ($scope) {
        $scope.showProductInformation = function (product) {
            alert(product);
        };
        $scope.addToCart = function (product) {
            alert(product);
        };
        $scope.products = ecommerce.products.data;
    }]);
}(ecommerce));


