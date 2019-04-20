(function(){
    'use strict';

     angular.module('blocks.router').provider('routerHelper', routerHelperProvider);

         routerHelperProvider.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];

         function routerHelperProvider($locationProvider, $stateProvider, $urlRouterProvider){
              this.config = {
                               // These are the properties we need to set
                  $stateProvider: undefined,
                  docTitle: '',
                  resolveAlways: {ready: function(){ } }
              };

              this.$get = function() {
                  return {
                      config: this.config
                  };
              };

              this.$get = RouteHelper;
              //$locationProvider.html5Mode(true);
              RouteHelper.$inject = ['$state', '$rootScope', '$location'];

              function RouteHelper($state, $rootScope, $location){

                  var handlingRouteChangeError = false;
                  var routesCounts = {
                       errors: 0,
                       changes: 0
                  }

                   var otherwisePath = 'index';

                   var states = [{
                                   state: 'dashboard',
                                   config: {
                                        abstract: false,
                                        templateUrl: 'app/views/dashboard.html',
                                        controller: 'Dashboard',
                                        controllerAs: 'vm',
                                        url: '/dashboard',
                                        settings: {
                                            nav: 1,
                                            content: '<i class="fa fa-dashboard"></i> Dashboard'
                                        }
                                   }
                                 },
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
                                 },
                                 {
                                    state: 'shell',
                                    config: {
                                         abstract: false,
                                         templateUrl: 'app/views/shell.html',
                                         //template: '<ui-view class="shuffle-animation"/>',**/
                                         controller: 'Shell',
                                         url: '/shell',
                                         title: 'shell'
                                    }
                                 }
                               ];
                  //var routes = [];
                  //var $routeProvider = routerHelperProvider.config.$routeProvider;

                  var hasOtherwise = false;

                  var service = {
                      configureStates: configureStates,
                      getStates: getStates,
                      routesCounts: routesCounts
                  }
                  init();

                  return service;
                  // function configureStates(states, otherwisePath){
                  function configureStates() {
                      states.forEach(function(state) {

                            /*$urlRouterProvider.when($state.url, function($match, $stateParams){
                                 if($state.$current.navigable !== state || !equalForKeys($match, $stateParams)){
                                     $state.transitionTo(state, $match, false);
                                 }
                            });*/

                            //$stateProvider.state(state.state, state.config);
                          //state.config.resolve = angular.extend(state.config.resolve || {}, routerHelperProvider
                            //         .config.resolveAlways);
                          $stateProvider.state(state.state, state.config);
                      });
                      if (otherwisePath && !hasOtherwise) {
                           hasOtherwise = true;
                           $urlRouterProvider.otherwise(otherwisePath);
                      }
                  }

                  function handlingRoutingErrors(){
                      $rootScope.$on('$stateChangeError', function(event, current, previous, rejection){
                              if (handlingRouteChangeError) {
                                   return;
                              }
                              routeCounts.errors++;
                              handlingRouteChangeError = true;

                              var destination = (current && (current.title || current.name || current.loadedTemplateUrl)) ||
                                                      'unknown target';
                              var msg = 'Error routing to ' + destination + '. ' + (rejection.msg || '');
                              logger.warning(msg, [current]);
                              $state.go('index');
                           }
                      )
                  }

                  function init() {
                              handlingRoutingErrors();
                              updateDocTitle();
                  }

                  function getStates(){
                       return $state.get();
                  }

                  function updateDocTitle() {
                              $rootScope.$on('$stateChangeSuccess', function(event, current, previous) {
                                  console.log('Success', event);
                                  console.log('Success', current);
                                  console.log('Success', previous);
                                                           //console.log('Success', rejection);
                                  routeCounts.changes++;
                                  handlingRouteChangeError = false;

                                  var title = routerHelperProvider.config.appTitle + ' ' + (current.title || '');
                                  $rootScope.title = title; // data bind to <title>
                              });

                              $rootScope.$on('$stateChangeStart',  function(event, next) {
                                     console.log('Change detected', event);
                                     console.log('Change detected', next);
                              });
                  }
              }

         }

      /**
      angular
             .module('blocks.router')
             .provider('routerHelperProvider', routerHelperProvider)
             .factory('routerHelper', routerHelper);

         routerHelperProvider.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];
         // Must configure via the routehelperConfigProvider
         function routerHelperProvider($locationProvider, $stateProvider, $urlRouterProvider) {
             /* jshint validthis:true */
             /**this.config = {
                 // These are the properties we need to set
                 $stateProvider: undefined,
                 docTitle: '',
                 resolveAlways: {ready: function(){ } }
             };

             this.$get = function() {
                 return {
                     config: this.config
                 };
             };
         }

         routerHelper.$inject = ['$location', '$rootScope', '$state', 'logger', 'routerHelperProvider'];
         function routerHelper($location, $rootScope, $state, logger, routerHelperProvider) {
             var handlingRouteChangeError = false;
             var routeCounts = {
                 errors: 0,
                 changes: 0
             };
             var states = [];
             var $stateProvider = routerHelperProvider.config.$stateProvider;

             var service = {
                 configureStates: configureStates,
                 getStates: getStates,
                 routeCounts: routeCounts
             };

             init();

             return service;**/
             ///////////////
             // function configureStates(states, otherwisePath){
             /**function configureStates(states, otherwisePath) {
                  states.forEach(function(state) {**/
                      /*$urlRouterProvider.when($state.url, function($match, $stateParams){
                         if($state.$current.navigable !== state || !equalForKeys($match, $stateParams)){
                            $state.transitionTo(state, $match, false);
                         }
                      });*/
                   /**
                      state.config.resolve = angular.extend(state.config.resolve || {}, routerHelperProvider.config.resolveAlways);
                      $stateProvider.state(state.state, state.config);
                  });
                      if (otherwisePath && !hasOtherwise) {
                          hasOtherwise = true;
                          $urlRouterProvider.otherwise(otherwisePath);
                      }
             }
              **/
             /**function configureRoutes(routes) {
                 routes.forEach(function(route) {
                     route.config.resolve =
                         angular.extend(route.config.resolve || {}, routerHelperProvider.config.resolveAlways);
                     $routeProvider.when(route.url, route.config);
                 });
                 $routeProvider.otherwise({redirectTo: '/'});
             }**/
/**
             function handleRoutingErrors() {
                 // Route cancellation:
                 // On routing error, go to the dashboard.
                 // Provide an exit clause if it tries to do it twice.
                 $rootScope.$on('$stateChangeError',
                     function(event, current, previous, rejection) {
                         if (handlingRouteChangeError) {
                             return;
                         }
                         routeCounts.errors++;
                         handlingRouteChangeError = true;
                         var destination = (current && (current.title || current.name || current.loadedTemplateUrl)) ||
                             'unknown target';
                         var msg = 'Error routing to ' + destination + '. ' + (rejection.msg || '');
                         logger.warning(msg, [current]);
                         $state.go('index');
                     }
                 );
             }

             function init() {
                 handleRoutingErrors();
                 updateDocTitle();
             }

             function getStates() {
                 for (var prop in $state.states) {
                     if ($state.states.hasOwnProperty(prop)) {
                         var state = $state.states[prop];
                         var isState = !!state.title;
                         if (isState) {
                             states.push(state);
                         }
                     }
                 }
                 return states;
             }

             function updateDocTitle() {
                 $rootScope.$on('$routeChangeSuccess',
                     function(event, current, previous) {
                         routeCounts.changes++;
                         handlingRouteChangeError = false;
                         var title = routerHelperProvider.config.docTitle + ' ' + (current.title || '');
                         $rootScope.title = title; // data bind to <title>
                     }
                 );
             }
     }**/
})();