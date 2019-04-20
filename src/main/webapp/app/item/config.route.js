(function(){

    'use strict';

    angular.module('blocks.router').run(appRun);
    appRun.$inject = ['routerHelper'];

    function appRun(routerHelper){
        routerHelper.configureStates();
    }
    function getStates(){
        return [
                {
                    state: 'item',
                    config: {
                        abstract: false,
                        templateUrl: 'app/views/item.html',
                        //template: '<ui-view class="shuffle-animation"/>',**/
                        controller: 'Item',
                        controllerAs: 'vm',
                        url: '/item'
                    }
                }
            ];
    }
})