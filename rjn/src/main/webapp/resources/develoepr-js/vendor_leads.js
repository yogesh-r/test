RJN.controller('vendorLeadsCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.leadList = {};
	$scope.leadStatus = 'unread';

	$scope.loadData = function() {
		$http.get(_context+'/vendor/product/rest/leads?status='+$scope.leadStatus).then(function(response) {
 			$scope.leadList = response.data.leads;
 		});
    };
    $scope.loadData();
    
	$scope.markRead = function(leadId) {
		$http.get(_context+'/vendor/product/rest/update-lead-status/'+leadId+'?status=read').then(function(response) {
			toastr.success('Successfully Updated'); 
			$scope.loadData();
		});
    };
    $scope.readLead = function(change) {
		$http.get(_context+'/vendor/product/rest/leads?status='+change).then(function(response) {
			$scope.leadList = response.data.leads;
		});
    };
}]);