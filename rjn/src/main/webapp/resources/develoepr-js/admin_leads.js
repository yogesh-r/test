RJN.controller('adminLeadsCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.leadList = {};
	$scope.leadStatus = 'unread';
	$scope.change = $scope.selectItems[1];

	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/lead-list?status='+$scope.leadStatus).then(function(response) {
 			$scope.leadList = response.data.leads;
 		});
    };
    $scope.loadData();
    
	$scope.markRead = function(leadId,leadStatus) {
		$http.get(_context+'/admin/rest/update-lead-status/'+leadId+'?status=read').then(function(response) {
			toastr.success('Successfully Updated'); 
			$scope.loadData();
		});
    };
    
    $scope.readLead = function(change) {
    	console.log(change);
		$http.get(_context+'/admin/rest/lead-list?status='+change).then(function(response) {
			$scope.leadList = response.data.leads;
		});
    };
    
    $scope.allLead=function(){
    	$http.get(_context+'/admin/rest/allLead').then(function(response){
    		$scope.leadList = response.data.allLead;
    	});
    }
}]);