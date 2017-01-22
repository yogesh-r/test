defysope.controller('CompanyListCtrl', [ '$scope', '$http', 'fileUpload' , function ($scope, $http, $fileUpload) {
	$scope.companies = {};	
	
	$scope.approveCompany = function(thisCompany, status) {
		$http.post(_context + '/administration/approve/company?status=' + status,
				thisCompany).then(function(response) {
				if(response.data.success){
					thisCompany.approve= true;
					toastr.success('Approved successfully.');
				}
		});
	};
	
	// load courses when page is loaded
	$http.get(_context + '/administration/laod/company-list').success(
	function(response) {
		$scope.companies = response.viewCompanies;
	});
	
    $scope.uploadFile = function(){
    	alert("function called >>");
        var file = $scope.myFile;
        console.log('file is ' );
        console.dir(file);
        var uploadUrl = _context + '/uploadDocument';
        $fileUpload.uploadFileToUrl(file, uploadUrl);
        
    };
}]);