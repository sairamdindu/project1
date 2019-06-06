angular.module('app',['ngResource','ui.router']).controller('ss', ['$scope', '$resource', function($scope, $resource) {
 
	$scope.RegisterModal={};
	 $scope.userListt=[];
	 $scope.sh=function(){
		 $resource('http://localhost:8080/api/getRegister').query(function(result) {
			   $scope.userListt=result;
			  });
		 }
	
	 $scope.sh();
 $scope.save = function() {
	 $scope.$watch('myVar', function() {
	        alert('hey, myVar has changed!'+JSON.stringify($scope.RegisterModal));
	    });

   $resource('/api/reg').save($scope.RegisterModal,function(data) {
	   $scope.sh();
   return data
  });
   }
 
 
 /*sairam*/
 $scope.edit=function(id,fname,lname,email,password,college){
	 $scope.college={};
	 $scope.collegess=[];
	 $scope.RegisterModal.id=id;
	 $scope.RegisterModal.firstname=fname;
	 $scope.RegisterModal.lastname=lname;
	 $scope.RegisterModal.email=email;
	 $scope.RegisterModal.password=password;
	 $scope.college.collegename=college.collegename;
	 $scope.collegess.push($scope.college);
	 $scope.colleges=$scope.collegess;
//	   $resource('http://localhost:8080/api/get/'+id+'').query(function(result) {
//		   alert(result)
//	      $scope.userReg=result;
//	      alert($scope.userReg)
//	  }); 
 };
 
 $scope.deletee=function(id){
	   $resource('http://localhost:8080/api/delete/'+id+'').query(function(data) {
		   $scope.sh();
	   return data
	  }); 
 };
 $scope.update=function(id,n,s,m,d){
	 $resource('/api/update').update($scope.RegisterModal,function(data) {
		   $scope.sh();
	   return data
	  });
//	 $resource('http://localhost:8080/api/update/'+id+'').query(function(data) {
//		   $scope.sh();
//	  });
 }
 $resource('/api/getAllColleges').query(function(data){
	 $scope.colleges=data;
 });
 
}]);