/*ecommerce.factory('Cart' , ['$http' , function($http ){

    return {

        addToCart : function(product) {

            var d = { id : '-' , email : '-' , products : [] };

            $http.get('/services/cart/1.json').success(function(data){

                console.log(data);

            }).then(function(result){
                console.log(JSON.stringify(result));
            });

            return d;
        }

    }


}])*/;

(function(ec){
    'use strict';
    ec.factory('CartService', function ($http) {

        return {

            add: function (product, cart) {

                return $http.post("/cart.do", product).success(function (data, status) {

                });
            },

            getData: function (cart) {
                return $http.get("/cart.do").success(function (data, status) {
                    cart.id = data.id;
                    cart.email = data.email;
                    cart.products = data.products;

                }).error(function (data, status) {

                });

            }

        };

    })
})(ecommerce);
