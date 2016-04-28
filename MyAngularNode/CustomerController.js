(function () {
    
    var CustomerController = function($scope, $log, customerFactory){
    $scope.sortBy = 'name';
    $scope.reverse = 'false';
    $scope.customers = [];
    
  function init() {
   customerFactory.getCustomers()
      .success(function (customers) {
          $scope.customers = customers;
      })
      .error(function (data,status) {
          $log.log(data.error + ' ' + status);
      });
  }
  
    init();
    $scope.doSort = function (propName) {
        $scope.sortBy = propName;
        $scope.reverse = !$scope.reverse;
    };
    
        
}; 
    
    angular.module('customerApp')
    .controller('CustomerController', CustomerController);   
    
}());