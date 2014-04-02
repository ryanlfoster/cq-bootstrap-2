
(function(ec){
    'use strict';
    ec.factory('CartService', function ($http) {

        return {

            add: function (product, cart) {

                return $http.post("/en.cart.add.do", product).success(function (data, status) {

                });
            },

            getData: function (cart) {
                return $http.get("/en.cart.view.do").success(function (data, status) {
                    cart.id = data.id;
                    cart.email = data.email;
                    cart.products = data.products;

                }).error(function (data, status) {

                });

            }

        };

    })
})(ecommerce);
