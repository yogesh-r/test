RJN.controller('categoryListCtrl', [ '$scope', '$http', 'fileUpload' , function ($scope, $http, fileUpload) {
	
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        var uploadUrl = _context + "/admin/bulk-register-category";
        fileUpload.uploadFileToUrl(file, uploadUrl);
        $scope.loadData();
        $scope.displayAddForm = false;
    };
    
	$scope.categoryList = [];
	$scope.editCategory = {};
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/product-category-list').then(function(response) {
 			$scope.categoryList = response.data.categoryList;
 		});
    };
    
	$scope.editForm = function(thisId) {
		$http.get(_context+'/admin/rest/register-category/' + thisId).then(function(response) {
 			$scope.editCategory = response.data.thisCategory;
 			$scope.displayAddForm = true;
 		});
    };

	$scope.addForm = function() {
		$scope.editCategory = {};
		$scope.displayAddForm = true;
	};
	
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
	$scope.saveCategory = function(thisCategoryForm) {
		console.log(thisCategoryForm);
		$http.post(_context+'/admin/register-category', thisCategoryForm).then(function(response) {
			$scope.editCategory = {};
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.loadData();
		});
	};
   
    
    $scope.loadData();
}]);