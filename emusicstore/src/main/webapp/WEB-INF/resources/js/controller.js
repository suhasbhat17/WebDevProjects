/**
 * Created by suhas on 5/20/2016.
 */
var cartApp = angular.module('cartApp',[]);

cartApp.controller('cartCtrl',function($scope, $http){

    $scope.refreshCart = function(){
        $http.get("/mymusicstore/rest/cart/"+$scope.cartId).success(function(data){
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete("/mymusicstore/rest/cart/"+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCart = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
        $http.put("/mymusicstore/rest/cart/add/"+productId).success(function () {
            alert("Product Successfully Added to Cart");

        });
    };

    $scope.removeFromCart = function(productId){
        $http.put('rest/cart/remove/' + productId).success(function(data){
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;
        for (var i=0; i < $scope.cart.cartItems.length; i++){
            grandTotal+= $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    }

});