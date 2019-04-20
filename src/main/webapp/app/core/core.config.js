(function() {
    'use strict';

    var core = angular.module('app.core');

    /*core.config(toastrConfig);
    toastrConfig.$inject = ['toastr'];

    *//* @ngInject *//*
    function toastrConfig(toastr) {
        toastr.options.timeOut = 4000;
        toastr.options.positionClass = 'toast-bottom-right';
    }*/

    var config = {
        appErrorPrefix: '[Temporary Error] ', //Configure the exceptionHandler decorator
        appTitle: 'Online store: ',
        version: '1.0.0'
    };

    core.value('config', config);
    core.config(configure);

    configure.$inject = ['$logProvider', '$stateProvider', 'routerHelperProvider', 'exceptionHandlerProvider'];

    /* @ngInject */
    function configure ($logProvider, $stateProvider, routerHelperProvider, exceptionHandlerProvider) {
        // turn debugging off/on (no info or warn)
        if ($logProvider.debugEnabled) {
            $logProvider.debugEnabled(true);
        }

        /**$stateProvider.state('index',{
            url:'/#',
            templateUrl: 'index.html',
            publicAccess: true
        });**/
        exceptionHandlerProvider.configure(config.appErrorPrefix);
    }
})();