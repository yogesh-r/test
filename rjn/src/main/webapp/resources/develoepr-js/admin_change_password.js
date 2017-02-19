/**
 * Arnab
 */
RJN.controller('adminChangePasswordCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.changePassword = {};
	/*$scope.displayAddForm = false;*/
	
/*	$scope.loadData = function() {
		$http.get(_context+'/vendor/rest/change-password').then(function(response) {
 			$scope.thisProfile = response.data.vendorDetails;
 		});
    };
    $scope.loadData();*/
	
	$scope.saveChangePassword = function() {
		$http.post(_context + '/admin/rest/change-password',
				$scope.changePassword).then(function(response) {
					console.log()
					if (response.data.result == "success") {
						toastr.success('Profile saved successfully.');
					} else {
						toastr.success('Password didnt match please try again.');
					}
					
					$scope.changePassword = {}; 
		});
	};
}]);