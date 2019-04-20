(function(){

    'use strict';
    angular.module('blocks.router').run(appRun);
    appRun.$inject = ['routerHelper'];

    function appRun(routerHelper){
        routerHelper.configureStates();
    }

    /**function getStates(){
        return [
                {
                    state: 'sidebar',
                    config: {
                        abstract: false,
                        templateUrl: 'app/sidebar/item.html',
                        controller: 'SideBar',
                        url: '/sidebar'
                    }
                }
            ];
    }**/
})