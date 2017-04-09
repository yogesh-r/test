/**
 * Arnab
 */

RJN.controller('adminProductDetails', [ '$scope', '$http' , function ($scope, $http) {
	$scope.getVendor={};
	$scope.branchName={};
	$scope.displayAddForm=false;
	$scope.productData={};
	$scope.branchOwner={};
	
	/*$scope.loadBranchOwner = function() {
		$http.get(_context+'/admin/rest/arnab').then(function(response) {
 			$scope.getVendor = response.data.vendorProfile;
 		});
    };
    $scope.loadBranchOwner();
	*/
	$scope.loadBranch = function(branchOwner) {
		$http.get(_context+'/admin/rest/arnab/'+branchOwner).then(function(response) {
 			$scope.branchName = response.data.thisBranch;
 			//$scope.displayAddForm=false;
 		});
    };
    
    $scope.getData = function() {
    	//console.log($scope.branchOwner);
    	//console.log($scope.branchName[0].id);
		$http.get(_context+'/admin/rest/getData/'+$scope.branchOwner+'/'+$scope.branchName[0].id).then(function(response) {
 			$scope.productData = response.data.getData;
 			$scope.displayAddForm=true;
 		});
    };
	
}]);