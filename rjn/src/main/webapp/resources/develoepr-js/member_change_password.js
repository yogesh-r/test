/**
 *Arnab 
 */
RJN.controller('memberChangePasswordCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.changePassword = {};
	$scope.saveChangePassword = function() {
		$http.post(_context + '/member/change-password',
				$scope.changePassword).then(function(response) {
					if (response.data.result == "success") {
						toastr.success('Profile saved successfully.');
					} else {
						toastr.warning('Password didnt match please try again.');
					}
					
					$scope.changePassword = {}; 
		});
	};
}]);