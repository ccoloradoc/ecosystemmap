var ecosystemApp = angular.module('ecosystemApp', ['ngRoute']);

ecosystemApp.factory('PathInterceptor', ['$location',function($location) {  
    var path = {
        request: function(config) {
        	
        	var path = $location.absUrl(); 
            var pathArray = path.split('/');
            var appContext = pathArray[3];
        	
        	config.url = "/"+appContext+config.url;

        	console.log('>>>>' + config.url);
  
            return config;
        },
        response: function(response) {
        	
   
            return response;
        }
    };
    return path;
}]);

ecosystemApp.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	$routeProvider
		.when("/", {templateUrl: '/views/portal.html', controller: 'portalController'})
		.when("/ecosystem/:id/archetype", {templateUrl: '/views/ecosystem.html', controller: 'ecosystemController'});
	
	$httpProvider.interceptors.push('PathInterceptor');
}]);


ecosystemApp.controller('portalController', ['$scope', '$http', function($scope, $http) {
		
	$http.get('/portal/ecosystem')
	.then(
		function(response) {
			$scope.ecosystems = response.data;
		}, 
		function(response) {
			$scope.error = "Error while retrieving information";
		});
}]);


ecosystemApp.controller('ecosystemController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {
	$scope.id = $routeParams.id;
	
	$http.get('/portal/ecosystem/' + $scope.id + '/archetype')
	.then(
		function(response) {
			$scope.archetypes = response.data;
		}, 
		function(response) {
			$scope.error = "Error while retrieving information";
		});
}]);