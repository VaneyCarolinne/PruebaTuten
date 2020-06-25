// eslint-disable-next-line strict
'use strict';


var app = angular.module('app', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
      .when("/", {
          controller: 'controlador',
          templateUrl: 'templates/home.html'
      })
      .when("/login/:userName/:userPassword", {
          controller: 'loginControl',
          templateUrl: 'templates/login.html'
      })
      .otherwise("/");
});

app.controller('controlador', function($scope, $http, $window) {
  // console.log("el scope",$scope);
  // $scope.userName = "testapis%40tuten.cl";
  // $scope.userPassword = "1234";
  // console.log("el scope.userName",$scope.userName);
  // console.log("el scope.userPassword",$scope.userPassword);

  $scope.user = {};
  $scope.userAdmin = {};
  $scope.myVal = false;
  let status = 0;
  $scope.logIn =  function(){
    // $scope.user = await PutUser($scope.userName, $scope.userPassword);
    // console.log("$scope.user: ", $scope.user);
    let url = "https://dev.tuten.cl/TutenREST/rest/user/"+$scope.userName;
    let header = {
      headers: {
        "Content-type": "application/json; charset=UTF-8",
        "Accept": "application/json",
        "password": $scope.userPassword,
        "app": "APP_BCK"
      }
    };
    let body = JSON.stringify({});
    console.log("url $HTTP: ", url);
    $http.put(url, body, header).then(function (response) {

        // This function handles success
        $scope.user = response.data;
        status = response.status;
        console.log("SUCCESS: ", response);
        console.log("$scope.user: ", $scope.user);

        $scope.myVal = true;
        console.log("$MyVal: ",$scope.myVal);


      }, function (response) {
        $scope.myVal = false;
        // this function handles error
        console.error('Error:', response);
        $window.alert(response.data);

      });



  }






});


//parte II
app.controller('loginControl', function($scope, $http, $routeParams) {

  $scope.userName = $routeParams.userName;
  $scope.userPassword = $routeParams.userPassword;
  $scope.user = {};
  $scope.userAdmin = {};
  let status = 0;
  $scope.auxUser = {};

    // $scope.user = await PutUser($scope.userName, $scope.userPassword);
    // console.log("$scope.user: ", $scope.user);
    let url = "https://dev.tuten.cl/TutenREST/rest/user/"+$scope.userName;
    let header = {
      headers: {
        "Content-type": "application/json; charset=UTF-8",
        "Accept": "application/json",
        "password": $scope.userPassword,
        "app": "APP_BCK"
      }
    };
    let body = JSON.stringify({});
    console.log("url $HTTP: ", url);
    $http.put(url, body, header).then(function (response) {

        // This function handles success
        $scope.user = response.data;
        status = response.status;
        console.log("SUCCESS: ", response);
        console.log("$scope.user: ", $scope.user);

              //parte II
      let urlII = "https://dev.tuten.cl/TutenREST/rest/user/contacto%40tuten.cl/bookings?current=true";


      console.log("urlII $HTTP: ", urlII);

      $http({

        method: 'GET',
        url: urlII,
          headers: {
            "Accept": "application/json",
            "adminemail": "testapis@tuten.cl",
            "token": $scope.user['sessionTokenBck'],
            "app": "APP_BCK"
          }
        }).then(function success(response) {

          $scope.userAdmin = response.data;
          $scope.auxUser = $scope.userAdmin;
          console.log("SUCCESS: ", response);
          console.log("$scope.userAdmin: ", $scope.userAdmin);

        }, function error(response) {

          console.error('Error:', response);

        });



      }, function (response) {

        // this function handles error
        console.error('Error:', response);

      });


      $scope.search =  function(){
        let result = {}
        let v1 = $scope.bookingPrice === "" || $scope.bookingPrice === null || $scope.bookingPrice === undefined
        let v2 = $scope.bookingId === "" || $scope.bookingId === null || $scope.bookingId === undefined

        // console.log("SCOOPES: ", $scope.bookingPrice, " ",  $scope.bookingId);
        // console.log("VALIDATIONS: ", v1," ", v2);

        if(!v1 && !v2)
          result = $scope.userAdmin.filter(admin => admin.bookingId == $scope.bookingId && admin.bookingPrice == $scope.bookingPrice );

        if((!v1 && v2) || (v1 && !v2) )
          result = $scope.userAdmin.filter(admin => admin.bookingId == $scope.bookingId || admin.bookingPrice == $scope.bookingPrice );

        if(v1)
          result = $scope.userAdmin.filter(admin => admin.bookingId == $scope.bookingId);

        if(v2)
          result = $scope.userAdmin.filter(admin => admin.bookingPrice == $scope.bookingPrice );

        if(v1 && v2)
          console.log("No hay Filtro");
        else
          $scope.userAdmin = result;

      }

      $scope.reset =  function(){
        $scope.userAdmin = $scope.auxUser;
      }











})
