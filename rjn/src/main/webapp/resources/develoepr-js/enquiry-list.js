/**
 * Arnab
 */
RJN.controller('enquiryListCtrl', [ '$scope', '$http' , function ($scope, $http){
	$scope.enquiryList=[];
	$scope.isLoadMore = true;
	$scope.startingPage = 0; 
	$scope.totalRow = 0; 
	
	$scope.loadData=function(){
		
	};
	
	$scope.init = function(value) {
		$scope.totalRow = 1;
		$http.get(_context+'/admin/rest/enquiry-list?pageNo='+$scope.startingPage).then(function(response) {
 			$scope.enquiryList = response.data.vendorEnquirys;
 		});
    };
    
    $scope.loadMore = function() {
		$scope.startingPage = $scope.startingPage +1;
  		$http.get(_context+'/admin/rest/enquiry-list?pageNo='+$scope.startingPage).then(function(response) {
            angular.forEach(response.data.vendorEnquirys, function(item){
                $scope.enquiryList.push(item);
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