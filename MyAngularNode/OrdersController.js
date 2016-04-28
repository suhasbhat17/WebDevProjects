(function() {

  var OrdersController = function($scope, $routeParams,customerFactory) {
    var customerId = $routeParams.customerId;
    $scope.customer = null;

    function init() {

     customerFactory.getCustomer(customerId)
        .success(function (customer) {
          $scope.customer = customer;
      })
      .error(function (data,status) {
          $log.log(data.error + ' ' + status);
      });
    }

    init();
  };


  OrdersController.$inject = ['$scope', '$routeParams','customerFactory'];
  angular.module('customerApp')
    .controller('OrdersController', OrdersController);

}());