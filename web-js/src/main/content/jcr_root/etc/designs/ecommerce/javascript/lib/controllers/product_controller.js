/*global ecommerce: true */
/*global alert: true, CQ: true */


(function (ecomm) {
    'use strict';
    ecomm.controller('ProductsController', ['$scope', '$http', function ($scope, $http) {
        $scope.products = ecomm.products.data;


        $scope.moo = function() {
            alert('moo');
        }
    }]);
}(ecommerce));


