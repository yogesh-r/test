RJN.controller('vendorListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.vendorList = [];
	$scope.startingPage = 0; 
	$scope.totalRow = 0; 
	$scope.isLoadMore = true;

	$scope.init = function(value) {
		$scope.totalRow = value;
		$http.get(_context+'/admin/rest/vendor-list?pageNo='+$scope.startingPage).then(function(response) {
 			$scope.vendorList = response.data.vendorList;
 		});
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
}]);