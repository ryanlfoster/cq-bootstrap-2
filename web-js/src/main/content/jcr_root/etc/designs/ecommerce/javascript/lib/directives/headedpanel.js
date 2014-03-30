/*global ecommerce: true */
/*global alert: true */


(function (ecomm) {
    'use strict';
    ecomm.directive('headedPanel', function (){
        return {
            scope: {
                headerText : "@",
                bodyText: "@"

            },
            restrict: 'E',
            templateUrl: '/etc/designs/ecommerce/templates/headedpanel.html',
            replace : true,
            controller : function ( $scope ){

            }

        };
    });
}(ecommerce));


