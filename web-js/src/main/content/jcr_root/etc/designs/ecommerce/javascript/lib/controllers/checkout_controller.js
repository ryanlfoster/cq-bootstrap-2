/*global ecommerce: true */
/*global alert: true, CQ: true */

(function (ecomm) {
    'use strict';
    ecomm.controller('CheckoutController', ['$scope', '$http', function ($scope, $http) {

        $scope.awaitingCheckout = true;

        $scope.checkout = function(customer){
//            $http.post('/en.cart.checkout.do' , customer).success(function(data,status){
//                $scope.awaitingCheckout = false;
//                $scope.checkoutMessage = data.success;
//
//            });
        }

        $scope.reset = function(){

        }

    }]);
}(ecommerce));
