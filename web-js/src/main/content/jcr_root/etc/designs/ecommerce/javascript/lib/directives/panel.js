/*global ecommerce: true */

(function (ecomm) {
    'use strict';
    ecomm.directive('panel', function (){
        return {
            scope: {
                bodyText : "@"
            },
            restrict: 'E',
            templateUrl: '/etc/designs/ecommerce/templates/panel.html',
            replace : true,
            controller : function ( $scope ){

            }
        };
    });
}(ecommerce));


