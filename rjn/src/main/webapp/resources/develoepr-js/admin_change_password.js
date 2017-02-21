/**
 * Arnab
 */
RJN.controller('adminChangePasswordCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.changePassword = {};
	$scope.saveChangePassword = function() {
		$http.post(_context + '/admin/rest/change-password',
				$scope.changePassword).then(function(response) {
					console.log()
					if (response.data.result == "success") {
						toastr.success('Profile saved successfully.');
					} else {
						toastr.warning('Password didnt match please try again.');
					}
					
					$scope.changePassword = {}; 
		});
	};
}]);