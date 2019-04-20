(function(){

    'use strict';
    angular.module('blocks.router').controller('ItemService', ItemService);

    ItemService.$inject = ['$http'];
    function ItemService($http){

        var itemService = {};

        itemService.searchItem = function(id){
        }
         return itemService;
    };
})();