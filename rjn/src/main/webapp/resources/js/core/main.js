var defysope = angular.module('defysope', [ 'ui.bootstrap', 'ngAnimate', 'mgo-angular-wizard' ]);


/*user define directives*/
defysope.directive('skwindow', function() {
	return {
		restrict : 'EA',
		templateUrl : "resources/template/skwindow.template.html",
		scope : {
			title : '@'
		},
		transclude : true,
		link : function(scope, element, attrs, dropdownCtrl, $http) {
			scope.title = attrs.title;
			scope.margin = attrs.margin;
			scope.height = attrs.height;
			scope.windowid = attrs.windowid;
			scope.windowclass = attrs.windowclass;
			scope.windowVisible = true;
			scope.fullscreen = false;
			scope.minimize = false;
			scope.enableRemoveSession = attrs.enableremovesession;
			scope.enableRemovePermanent = attrs.enableremovepermanent;
			scope.minimiseMaximiseWindow = function() {
				if (scope.minimize)
					scope.minimize = false;
				else
					scope.minimize = true;
			};
			scope.resizeWindow = function() {
				if (scope.fullscreen)
					scope.fullscreen = false;
				else
					scope.fullscreen = true;
			};
			scope.hideWindow = function(windowid) {
				scope.windowVisible = false;
			};
			scope.removeWindow = function(windowid) {
				scope.windowVisible = false;
			};

		}
	};
});


/* Directives for file upload */
/* Reference link = https://jsfiddle.net/JeJenny/ZG9re/
*/defysope.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

defysope.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    };
}]);


/*user define services for checking access right*/
defysope.service(
        "userService",
        function( $http, $q ) {
            // Return public API.
            return({
                checkUserRole: checkUserRole
            });
            // ---
            // PUBLIC METHODS.
            // ---
            // I add a friend with the given name to the remote collection.
            function checkUserRole( accessRight ) {
                var request = $http({
                    method: "get",
                    url: _context +"/kv/has-access-right",
                    params: {},
                    data: {
                    	accessRight: accessRight
                    }
                });
                return( request.then( handleSuccess, handleError ) );
            }

            // ---
            // PRIVATE METHODS.
            // ---
            // I transform the error response, unwrapping the application dta from
            // the API response payload.
            function handleError( response ) {
                // The API response from the server should be returned in a
                // nomralized format. However, if the request was not handled by the
                // server (or what not handles properly - ex. server error), then we
                // may have to normalize it on our end, as best we can.
                if (
                    ! angular.isObject( response.data ) ||
                    ! response.data.message
                    ) {
                    return( $q.reject( "An unknown error occurred." ) );
                }
                // Otherwise, use expected error message.
                return( $q.reject( response.data.message ) );
            }
            // I transform the successful response, unwrapping the application data
            // from the API response payload.
            function handleSuccess( response ) {
                return( response.data );
            }
        }
    );