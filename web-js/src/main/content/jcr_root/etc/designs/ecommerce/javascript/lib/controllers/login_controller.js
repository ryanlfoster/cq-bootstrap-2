
(function (ecomm) {

    ecomm.controller("LoginController", function($scope){


        $scope.model = {

            username : "",
            password : ""

        };

        $scope.formMessage = "";

        $scope.login = function () {
            $scope.formMessage = "Logging In!!";
        };


    });
})(ecommerce);
