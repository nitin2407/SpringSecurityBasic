app.controller('loginCtrl', function ($rootScope,$scope, $http, $timeout, $window, loginService, urlFactory) {

	$scope.submitForm = function (isValid) {

		var headers = {
			authorization: "Basic "
			+ btoa($scope.email + ":" + $scope.password)
		};

		$scope.userDetails = {
			email: $scope.email,
			password: $scope.password
		};

		if (isValid) {

			loginService.login(headers).then(
				function (data, status) {
					console.log(data);
					$rootScope.currentUser = data.data;
					$rootScope.isAuthenticated = true;
					if($rootScope.currentUser.userRole.role_id == 2){
						$timeout(function () {
	                    	$window.location.href = urlFactory.adminhome();
	                	}, 2000)
					}
					else{
						$timeout(function () {
	                    	$window.location.href = urlFactory.home();
	                	}, 2000)
					}
				},
				function (error) {
					console.log(error);
					swal({
						title: error.data.error,
						type: 'error',
						showCloseButton: true
					});

				}
			)};
	};


});