
  (function() {
    
      var app = angular.module('customerApp', ['ngRoute']);
      
      app.config(function($routeProvider){
        
        $routeProvider
        .when('/',{
          controller:'CustomerController',
          templateUrl:'customer.html'
        })
        .when('/orders/:customerId', {
          controller:'OrdersController',
          templateUrl:'orders.html'
        })
        .otherwise({redirectTo: '/'});
      });

}());