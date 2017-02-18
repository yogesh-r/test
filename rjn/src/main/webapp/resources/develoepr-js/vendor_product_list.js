RJN.controller('vendorProductListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.productList = {};
	$scope.thisProduct = {};
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/vendor/product/rest/product-list').then(function(response) {
 			$scope.productList = response.data.productList;
		});
    };
    
    $scope.loadData();
    
	$scope.saveProduct = function(thisProduct) {
		console.log(thisProduct);
		$http.post(_context+'/vendor/product/register-product', thisProduct).then(function(response) {
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.loadData();
		});
	};

	$scope.editForm = function(thisId) {
		$http.get(_context+'/vendor/product/register-product/' + thisId).then(function(response) {
 			$scope.thisProduct = response.data.thisVendor;
 			$scope.displayAddForm = true;
 		});
    };

	$scope.addForm = function() {
		$scope.displayAddForm = true;
	};
	
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	

   
    
  
}]);