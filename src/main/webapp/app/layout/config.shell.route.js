(function(){

    'use strict';
    angular.module('blocks.router').run(appRun);
    appRun.$inject = ['routerHelper'];

    function appRun(routerHelper){
        routerHelper.configureStates();
    }
})