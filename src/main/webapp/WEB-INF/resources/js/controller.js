//Angular javascript to rest services Refresh/Clear/Remove/Add

var cartApp = angular.module("cartApp", [])

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        //Get JSON data format when succes json data format will be stored in scope.cart = data //data = jsonobject
        $http.get('/expresstrade/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });

    };

    $scope.clearCart = function () {
        $http.delete('/expresstrade/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put("/expresstrade/rest/cart/add/" + productId).success(function (data) {
            $scope.refreshCart($http.get("/expresstrade/rest/cart/add/cartId"));
            alert("Product successfully added to the cart!")
        });
    };


    $scope.removeFromCart = function (productId) {
        $http.put('/expresstrade/rest/cart/remove/' + productId).success(function (data) {
            $scope.refreshCart($http.get('/expresstrade/rest/cart/cartId/'));
        });
    };

});