RJN.controller('branchListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.branchList = [];
	$scope.thisBranch = {};
	//$scope.vendorList = [];
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/branch-details').then(function(response) {
 			$scope.branchList = response.data.thisBranch;
 		});
    };
    
    
	$scope.addForm = function() {
		$scope.thisBranch = {};
		$scope.displayAddForm = true;
	};
	
    $scope.editForm = function(thisBranch) {
		$http.get(_context+'/admin/rest/edit-branch/' + thisBranch).then(function(response) {
 			$scope.thisBranch = response.data.editBranch;
 			$scope.displayAddForm = true;
 		});
    };
    
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
    $scope.saveBranch = function(branch) {
		branch.latitude =  angular.element('#latitude').val(); 
		branch.longitude = angular.element('#longitude').val(); 
		branch.address = angular.element('#autocomplete').val();
		
		$http.post(_context+'/admin/rest/register-branch', branch).then(function(response) {
			$scope.editCategory = {};
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.loadData();
		});
	};
	
    $scope.loadData();
	
}]);