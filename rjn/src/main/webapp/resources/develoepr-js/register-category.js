RJN.controller('registerCategoryCtrl', [ '$scope', '$http' , function ($scope, $http) {
	
	// variable decelaration
	$scope.thisCategory = {
	};

	
	$scope.saveCategory = function(thisCategoryForm) {
		
		
		
		$http.post('register-category', thisCategoryForm).then(function(response) {
					$scope.thisCategory = {};
					toastr.success('Register Successfully');
		});
		
		
	};
	
	
	
	
	
	
	
}]);