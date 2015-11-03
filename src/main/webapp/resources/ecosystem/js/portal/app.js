var ecosystemApp = angular.module('ecosystemApp', ['ngRoute', 'ngResource']);

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
		.when("/ecosystem/:id/archetype", {templateUrl: 'views/ecosystem.html', controller: 'ecosystemController'})
		.otherwise({redirectTo: '/'});
	
	$httpProvider.interceptors.push('PathInterceptor');
}]);


ecosystemApp.service('ecosystemService', [ '$resource', function($resource) {
	
	var self = this;
	
	this.ecosystemAPI = $resource('portal/ecosystem/:ecosystemId', {ecosystemId: '@id'}, { update: { method: 'PUT' }, delete: { method: 'DELETE', isArray: true }});
	
	this.query = function() {
		return self.ecosystemAPI.query();
	}
	
	this.get = function(id) {
		return self.ecosystemAPI.get({ecosystemId:id});
	}
	
	this.remove = function(id) {
		return self.ecosystemAPI.delete({ecosystemId:id});
	}
	
	this.update = function(id, object) {
		return self.ecosystemAPI.update({ecosystemId:id}, object);
	}
	
	this.save = function(object) {
		return self.ecosystemAPI.save({}, object);
	}

}]);	


ecosystemApp.controller('portalController', ['$scope', 'ecosystemService', function($scope, ecosystemService) {

	$scope.displayForm = false;
	
	$scope.resetForm = function() {
		$scope.objectForm = {
				object: {
					name: '',
					description: ''
				},
				meta: {
					title: 'Ecosystem'
				}
			};	
	}

	
	$scope.actions = {
			panel: {
				create: function() {
					$scope.resetForm();
					$scope.displayForm = true;
				},
				onLoad: function() {
					$scope.resetForm();
					$scope.items = ecosystemService.query();
				}
			},
			card:  {
				view: function(item) {
					//TODO
					console.log(item.id);
				},
				edit: function(item) {
					$scope.objectForm.object = item;	
					$scope.displayForm = true;
				},
				remove: function(item) {
					$scope.items = ecosystemService.remove(item.id);
				}
			},
			
			form: {
				submit: function() {
					//TODO
					console.log($scope.objectForm.object.id );
					if($scope.objectForm.object.id != undefined)
						ecosystemService.update($scope.objectForm.object.id, $scope.objectForm.object);
					else
						$scope.items.push(ecosystemService.save($scope.objectForm.object));
						
					$scope.displayForm = false;
				},
				cancel: function() {
					$scope.resetForm();
					$scope.displayForm = false;
				}
			}
	};	
}]);


ecosystemApp.directive('panel', function() {
	return {
		restrict: 'AE',
		templateUrl: 'directives/panel.html',
		replace: true,
		transclude: true,
		scope: {
			objectList: '=',
			actions: '='
		},
		controller: ['$scope', function($scope) {
			for(var name in $scope.actions.panel) {
				$scope[name] = $scope.actions.panel[name]
			}
			
			this.initializeItem = function( card ) {
				for(var name in $scope.actions.card) {
					card[name] = $scope.actions.card[name]
				}
			}
			
			this.initializeForm = function( form ) {
				for(var name in $scope.actions.form) {
					form[name] = $scope.actions.form[name]
				}
			}
			
			$scope.onLoad();
		}],
		link: function(scope, element, attr) {
			$(document).foundation();
		}
	};
});

ecosystemApp.directive('item', function() {
	return {
		require: '^panel',
		restrict: 'AE',
		templateUrl: 'directives/item.html',
		replace: true,
		transclude: true,
		scope: {
			object: '='
		},
		link: function($scope, element, attr, controller) {
			controller.initializeItem($scope);
		}
	};
});

ecosystemApp.directive('itemForm', function($compile) {
	return {
		require: '^panel',
		restrict: 'AE',
		templateUrl: 'directives/item-form.html',
		replace: true,
		transclude: true,
		scope: {
			objectForm: '='
		},
		link: function(scope, element, attrs, ctrl) {
			ctrl.initializeForm(scope);
	    }
	};
});

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
