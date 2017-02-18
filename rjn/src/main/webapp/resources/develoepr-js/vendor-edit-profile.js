RJN.controller('vendorEditProfileCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.thisProfile = [];
	$scope.enableEdit = true;
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/vendor/rest/edit-profile').then(function(response) {
 			$scope.thisProfile = response.data.vendorDetails;
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
	
	$scope.saveVendorProfile = function() {
		$http.post(_context + '/vendor/edit-profile',
				$scope.thisProfile).then(function(response) {
					toastr.success('Profile saved successfully.');
					$scope.enableEdit = !$scope.enableEdit; 
		});
	};
}]);