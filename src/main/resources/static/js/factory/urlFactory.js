app.factory('urlFactory', function($window){
	
	var urlFactory = {};
	
	urlFactory.home = function(){ 
		return "http://" + $window.location.host + "/index.html"; 
	};
	urlFactory.adminhome = function(){ 
		return "http://" + $window.location.host + "/html/admin-home.html"; 
	};
	urlFactory.userhome = function(){ 
		return "http://" + $window.location.host + "/index.html"; 
	};

	return urlFactory;
	
});