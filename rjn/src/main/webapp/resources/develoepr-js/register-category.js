RJN.controller('registerCategoryCtrl', [ '$scope', '$http' , function ($scope, $http) {
	
	$scope.thisCategory = {};
	
	$scope.saveCategory = function(thisCategoryForm) {
		console.log(thisCategoryForm);
		$http.post('register-category',
				thisCategoryForm).then(function(response) {
					$scope.thisCategory = {};
					toastr.success('Register Successfully');
		});
	};
	
}]);