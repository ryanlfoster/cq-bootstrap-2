(function (ec) {
    ec.controller('CartController', function ($scope, CartService) {


        $scope.cart = {
            id: 0,
            email: "ssmithstone@me.com",
            products: []
        };

        CartService.getData($scope.cart);

        $scope.totalItemCount = function () {
            return $scope.cart.products.length;
        };

        $scope.productQuantity = function (sku) {
            var qty = 0;
            var ps = $scope.cart.products;
            for (; i < ps.length; i++) {
//               if(ps[i].sku === sku)

            }
            return qty;
        }

        $scope.totalCost = function () {
            var r = 0.00
            var ps = $scope.cart.products;
            var i = 0;
            for (; i < ps.length; i++) {
                r += parseFloat(ps[i].totalItemCost).toFixed(2);
            }
            return parseFloat(r).toFixed(2);
        };

        $scope.updateCartInformation = function (cart) {

            $scope.cart.id = $scope.cart.id + 1;
            $scope.cart.email = cart.email;
        };

    });

})(ecommerce);
