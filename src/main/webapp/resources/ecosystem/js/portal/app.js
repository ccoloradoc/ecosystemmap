var ecosystemApp = angular.module('ecosystemApp', ['ngRoute', 'ngAnimate']);

ecosystemApp.factory('PathInterceptor', ['$location', '$log',function($location, $log) {  
    return {
        request: function(config) {
        	
        	config.url = $('#rootContext').attr('href') +config.url;

        	$log.info('Accessing: ' + config.url);
        	
        	config.headers['_csrf'] = $('#csrf').val();
        	config.headers['X-CSRF-TOKEN'] = $('#csrf').val();
        	
            return config;
        },
        response: function(response) {
            return response;
        }
    };
}]);

ecosystemApp.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	$routeProvider
		.when("/", {templateUrl: 'views/portal.html', controller: 'portalController'})
		.when("/ecosystem/:id/archetype", {templateUrl: 'views/ecosystem.html', controller: 'ecosystemController'});
	
	$httpProvider.interceptors.push('PathInterceptor');
}]);


ecosystemApp.controller('portalController', ['$scope', '$http', function($scope, $http) {
	
	$scope.resetForm = function() {
		$scope.ecosystemForm = {
				name: '',
				description: ''
			};	
		
		$scope.displayForm = false;
	};
	
	//UPDATE
	$scope.prepareUpdate = function(id) {
		
		for(var i in $scope.ecosystems) {
			var ecosystem = $scope.ecosystems[i];
			console.log(id + ' v. ' + ecosystem.id);
			if(ecosystem.id == id) {
				$scope.ecosystemForm = ecosystem;
				$scope.displayForm = true;
			}
		}
		
		$scope.displayForm = true;
		$scope.create = false;
				
	};
	
	$scope.update = function() {
		$http.put('portal/ecosystem', $scope.ecosystemForm)
		.then(
			function(response) {
				$scope.resetForm();
				$scope.ecosystems = response.data;
			}, 
			function(response) {
				console.log(response);
			});
	}
	
	
	//POST
	$scope.submit = function() {
		$http.post('portal/ecosystem', $scope.ecosystemForm)
		.then(
			function(response) {
				$scope.resetForm();
				$scope.ecosystems.push(response.data);
			}, 
			function(response) {
				console.log(response);
			});
	};
	
	//DELETE
	$scope.remove = function(id) {
		$http.delete('portal/ecosystem/' + id)
		.then(
			function(response) {
				$scope.resetForm();
				$scope.ecosystems = response.data;
			}, 
			function(response) {
				console.log(response);
			});
	};
	
	//GET: Setup view
	$http.get('portal/ecosystem')
	.then(
		function(response) {
			$scope.ecosystems = response.data;
		}, 
		function(response) {
			$scope.error = "Error while retrieving information";
		});
	
	$scope.resetForm();
}]);


ecosystemApp.controller('ecosystemController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {
	$scope.id = $routeParams.id;
	
	$http.get('portal/ecosystem/' + $scope.id + '/archetype')
	.then(
		function(response) {
			$scope.archetypes = response.data;
		}, 
		function(response) {
			$scope.error = "Error while retrieving information";
		});
}]);