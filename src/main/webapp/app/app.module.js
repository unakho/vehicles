(function() {
    'use strict';

    var app = angular.module('app', [
        /*
         * Order is not important. Angular makes a
         * pass to register all of the modules listed
         * and then when app.dashboard tries to use app.data,
         * its components are available.
         */

        /*
         * Everybody has access to these.
         * We could place these under every feature area,
         * but this is easier to maintain.
         */ 
        'app.core',
        'app.widgets',

        /*
         * Feature areas
         */
        'app.dashboard',
        'app.layout'
    ]);

    /*app.config(['$urlRouterProvider', function($urlRouterProvider){

         $urlRouterProvider.when($state.url, function($match, $stateParams){
             if($state.$current.navigable !== state || !equalForKeys($match, $stateParams)){
                 $state.transitionTo(state, $match, false);
             }
         });
    }]);*/

    /**app.run(['$rootScope', '$state', function($rootScope, $state){
         $rootScope.$on('$stateChangeStart', function(event, next){
              event.preventDefault();
              if(next.publicAccess){
                   $state.go('dashboard');
              }
              else if(!next.publicAccess){
                   $state.go('index');
              }

              //event.preventDefault();
              console.log(event, next);
         });
    }]);**/
})();