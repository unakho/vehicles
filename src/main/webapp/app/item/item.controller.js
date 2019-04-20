(function(){

    'use strict';
    angular.module('blocks.router').controller('Item', Item);

    Item.$inject = ['$scope', '$state'];
    function Item($scope, $state){

           //$state.go('item');
          // $state.transitionTo("dashboard.topnav");
           $scope.searchItem = function(){
                 $state.go('item', {});
           }
    };
})();