(function() {
    'use strict';

    angular
        .module('app.layout')
        .controller('Sidebar', Sidebar);

    Sidebar.$inject = ['$state', 'routerHelper'];

    function Sidebar($state, routerHelper) {
        /*jshint validthis: true */
        var vm = this;
        var routes = routerHelper.getStates();
        vm.isCurrent = isCurrent;
        vm.sidebarReady = function(){
                 console.log('done animating menu')
             }; // example

        activate();

        function activate() { getNavRoutes(); }

        function getNavRoutes() {
            vm.navRoutes = routes.filter(function(r) {
                return r.settings && r.settings.nav;
            }).sort(function(r1, r2) {
                return r1.settings.nav - r2.settings.nav;
            });
        }

        function isCurrent(state) {
            if (!state.title || !$state.current || !$state.current.title) {
                return '';
            }
            var menuName = state.title;
            return $state.current.title.substr(0, menuName.length) === menuName ? 'current' : '';
        }
    }
})();