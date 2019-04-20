(function() {
    'use strict';

    angular
        .module('app.layout')
        .controller('TopNav', TopNav);

    TopNav.$inject = ['$state', '$timeout', 'config', 'logger', 'routerHelper'];

    function TopNav($state, $timeout, config, logger, routerHelper) {

        var states = routerHelper.getStates();

        function hideSplash() {
            //Force a 1 second delay so we can see the splash.
            $timeout(function() {
                vm.showSplash = false;
            }, 1000);
        }

        activate();

        function activate() { getNavRoutes(); }

        function getNavRoutes() {
            //$state.go("item");

            vm.navRoutes = routes.filter(function(state) {
            return state.settings && state.settings.nav;
           }).sort(function(r1, r2) {
              return r1.settings.nav - r2.settings.nav;
            });
        }
    }
})();