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
                    state: 'topnav',
                    config: {
                        abstract: false,
                        templateUrl: 'app/views/topnav.html',
                        controller: 'TopNav',
                        url: '/topnav',
                        title: 'topnav'
                    }
                }
            ];
    }**/
})