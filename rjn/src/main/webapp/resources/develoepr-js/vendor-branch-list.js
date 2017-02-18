RJN.controller('vendorBranchListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.branchList = {};
	$scope.vendorDetails = {};
	$scope.thisBranch = {};
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/vendor/rest/branch-list').then(function(response) {
 			$scope.branchList = response.data.branchList;
 			$scope.thisBranch.branchOwner = response.data.vendorDetails.id;
		});
    };
    
	$scope.editForm = function(thisId) {
		console.log("thisId >> "+thisId);
		$http.get(_context+'/vendor/register-branch/' + thisId).then(function(response) {
 			$scope.thisBranch = response.data.thisBranch;
 			$scope.displayAddForm = true;
 		});
    };

	$scope.addForm = function() {
		$scope.thisBranch = {};
		$scope.displayAddForm = true;
	};
	
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
	$scope.saveBranch = function(thisBranch) {
		console.log(thisBranch);
		$http.post(_context+'/vendor/register-branch', thisBranch).then(function(response) {
			$scope.thisBranch = {};
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.loadData();
		});
	};
   
    
    $scope.loadData();
}]);