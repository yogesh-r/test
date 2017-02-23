/**
 * Arnab
 */

RJN.controller('memberEditProfileCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.thisProfile = [];
	$scope.enableEdit = true;
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/member/rest/edit-profile').then(function(response) {
 			$scope.thisProfile = response.data.profileMaster;
 		});
    };
    $scope.loadData();
    
	$scope.enableEditFunction = function(){
		if ($scope.enableEdit == true) {
			$scope.enableEdit = false;
		}else{
			$scope.enableEdit = true;
		}
	};
	
	$scope.saveMemberProfile = function() {
		$http.post(_context + '/member/rest/edit-profile',
				$scope.thisProfile).then(function(response) {
					toastr.success('Profile saved successfully.');
					$scope.enableEdit = !$scope.enableEdit; 
		});
	};
}]);