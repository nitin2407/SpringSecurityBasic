app.controller('loginCtrl', function ($scope, $http, $timeout, $window, loginService, urlFactory) {


	$scope.fbauth = function () {
		loginService.fblogin().then(
			function (data, status) {
				console.log(data);
			},
			function (data, status) {
				swal({
					title: 'error',
					type: 'warning',
					showCloseButton: true
				});
			}
		)
	}

	$scope.googleauth = function () {
		loginService.googlelogin().then(
			function (data, status) {
				console.log(data);
			},
			function (data, status) {
				swal({
					title: 'error',
					type: 'warning',
					showCloseButton: true
				});
			}
		)
	}

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
					$scope.userDetails = data.data;
					//console.log($scope.userDetails);
					if ($scope.userDetails.message) {

						//alert(data.data.message[0]);
						swal({
							title: data.data.message[0],
							type: 'warning',
							showCloseButton: true
						});
					}
				},
				function (error) {
					console.log(error);

					//if (status == 401) {

					//alert(data.data[0].message);
					swal({
						title: error.data.error,
						type: 'error',
						showCloseButton: true
					});


					/*swal({
	                    title: 'not able to login',
	                    type: 'warning',
	                    showCloseButton: true	
	                });*/
					$timeout(function () {
						//$window.location.href = urlFactory.home();
					}, 2000)
				}
			).catch(function (data) {
				console.log(data)
			});
		};
	};


});