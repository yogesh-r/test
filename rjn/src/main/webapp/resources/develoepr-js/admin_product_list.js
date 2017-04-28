RJN.controller('adminProductDetails', [ '$scope', '$http' , function ($scope, $http) {
	$scope.branchName={};
	$scope.productData={};
	$scope.branchOwner={};
	$scope.displayAdd=false;
	$scope.editProduct={};
	$scope.loadBranch = function(branchOwner1) {
		$scope.branchOwner = branchOwner1;
		$http.get(_context+'/admin/rest/arnab/'+branchOwner1).then(function(response) {
 			$scope.branchName = response.data.thisBranch;
 		});
    };
    
    $scope.getData = function() {
		$http.get(_context+'/admin/rest/getData/'+$scope.branchOwner+'/'+$scope.branchName[0].id).then(function(response) {
 			$scope.productData = response.data.getData;
 			$scope.displayAdd = false;
 		});
    };
    
    $scope.addForm = function() {
		$scope.displayAdd = true;
	};
	
    $scope.closeForm = function() {
		$scope.displayAdd = false;
	};
	
	$scope.saveProduct=function(editProduct){
		$http.post(_context+'/admin/rest/register-product', editProduct).then(function(response) {
			$scope.editProduct={};
			toastr.success('Successfully Saved');
			$scope.displayAdd = false;
			$scope.getData();
		});
	};
	
	$scope.deleteProduct = function(thisId) {
		$http.get(_context+'/admin/rest/delete/product/' + thisId).then(function(response) {
 			$scope.thisProduct = response.data.message;
 			toastr.success($scope.thisProduct); 
 			$scope.getData();
 		});
    };
    
	$scope.editForm = function(thisId) {
		$http.get(_context+'/admin/rest/get-product/' + thisId).then(function(response) {
 			$scope.editProduct = response.data.thisVendor;
 			$scope.displayAdd = true;
 		});
    };
}]);