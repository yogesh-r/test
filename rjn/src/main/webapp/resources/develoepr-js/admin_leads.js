RJN.controller('adminLeadsCtrl', [ '$scope', '$http' , function ($scope, $http) {
	
	$scope.leadList = {};
	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/lead-list').then(function(response) {
 			$scope.leadList = response.data.leads;
 		});
    };
    
    $scope.loadData();
}]);