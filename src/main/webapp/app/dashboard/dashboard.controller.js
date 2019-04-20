(function() {
    'use strict';

    angular
        .module('app.dashboard')
        .controller('Dashboard', Dashboard);

    Dashboard.$inject = ['$q', 'dataservice', 'logger', '$state', 'routerHelper'];

    function Dashboard($q, dataservice, logger, $state, routerHelper) {

        /*jshint validthis: true */
        var vm = this;

        vm.news = {
            title: 'Discounted stock',
            description: '20% Discount for all listed stock below!'
        };
        vm.avengerCount = 0;
        vm.avengers = [];
        vm.title = 'Dashboard';

        var states = routerHelper.getStates();

        activate();

        /**function activate() {
            var promises = [getAvengerCount(), getAvengersCast()];
//            Using a resolver on all routes or dataservice.ready in every controller
//            return dataservice.ready(promises).then(function(){
            return $q.all(promises).then(function() {
                logger.info('Activated Dashboard View');
            });
        }
        **/
        function activate() { getNavRoutes(); }
                      function getNavRoutes() {

                 //                 $state.go("dashboard");
                 vm.navRoutes = states.filter(function(r) {
                  console.log('Current state==', r);
                  return r.settings && r.settings.nav;
              }).sort(function(r1, r2) {
                   return r1.settings.nav - r2.settings.nav;
             });
        }

        function getAvengerCount() {
            return dataservice.getAvengerCount().then(function(data) {
                vm.avengerCount = data;
                return vm.avengerCount;
            });
        }

        function getAvengersCast() {
     
            return dataservice.getAvengersCast().then(function(data) {
                vm.avengers = data;
                return vm.avengers;
            });
        }
    }
})();