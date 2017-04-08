RJN.controller('vendorListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.vendorList = [];
	$scope.startingPage = 0; 
	$scope.totalRow = 0; 
	$scope.isLoadMore = true;
	$scope.editVendor = {};
	$scope.displayAddForm = false;

	$scope.init = function(value) {
		$scope.totalRow = value;
		$http.get(_context+'/admin/rest/vendor-list?pageNo='+$scope.startingPage).then(function(response) {
 			$scope.vendorList = response.data.vendorList;
 		});
    };
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
	$scope.addForm = function() {
		$scope.editVendor = {};
		$scope.displayAddForm = true;
	};
    
	$scope.loadMore = function() {
		$scope.startingPage = $scope.startingPage +1;
  		$http.get(_context+'/admin/rest/vendor-list?pageNo='+$scope.startingPage).then(function(response) {
            angular.forEach(response.data.vendorList, function(item){
                $scope.vendorList.push(item);
            });
 		});
  		$scope.totalPage = $scope.totalRow / 2;
  		$scope.totalPage = Math.round($scope.totalPage);
  		if (parseInt($scope.totalPage) != parseInt($scope.startingPage)) {
  			$scope.isLoadMore = true;
  		} else {
  			$scope.isLoadMore = false;
  		}
	};
	$scope.editForm = function(thisId) {
		$http.get(_context+'/admin/rest/register-vendor/' + thisId).then(function(response) {
 			$scope.editVendor = response.data.thisVendor;
 			$scope.displayAddForm = true;
 		});
    };
	$scope.saveVendor = function(thisVendorForm) {
		
		var latitude =  angular.element('#latitude').val();
		var longitude =  angular.element('#longitude').val();
		// angular.element( document.querySelector( '#latitude' ) );
		console.log(latitude);
		console.log(longitude);
		
		thisVendorForm.latitude = latitude; 
		thisVendorForm.longitude = longitude; 

		$http.post(_context+'/admin/register-vendor', thisVendorForm).then(function(response) {
			$scope.editVendor = {};
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.init(0);
		});
	};
}]);