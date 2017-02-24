RJN.controller('adminLeadsCtrl', [ '$scope', '$http' , function ($scope, $http) {
	
	$scope.leadList = {};
	$scope.leadStatus = 'unread';
	
	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/lead-list?status='+$scope.leadStatus).then(function(response) {
 			$scope.leadList = response.data.leads;
 		});
    };
    $scope.loadData();
    
	$scope.markRead = function(leadId) {
		$http.get(_context+'/admin/rest/update-lead-status/'+leadId+'?status=read').then(function(response) {
			toastr.success('Successfully Updated'); 
			$scope.loadData();
		});
    };
    
}]);