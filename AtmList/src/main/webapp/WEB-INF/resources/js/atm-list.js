var ngAtmList = angular.module('atm-list', []);

ngAtmList.controller('ctrl-list',["$scope","$attrs", "$http", "$window", "$log", function($scope, $attrs, $http, $window, $log){
    $scope.atmServerList = [];
    $scope.currentPage = 0;
    $scope.pageSize = 10;
    
    $scope.numberOfPages=function(){
        return Math.ceil($scope.atmServerList.length/$scope.pageSize);                
    }
    for (var i=0; i<45; i++) {
        $scope.atmServerList.push("Item "+i);
    }
    
    $scope.listAtmServer = function() {
        $scope.showLoader = true;
        var req = {
            method: 'GET',
            url: $attrs.contextPath  + "/atmList",
            headers: {
                'Content-Type': 'application/json'
            }
        };

        $http(req).
            success(function(data, status, headers, config){
                $scope.showLoader = false;
                $scope.atmServerList = data;
            }).
            error(function(jqXHR, textStatus, errorThrown){
                alert('Woops something wen wrong with the AJAX call');
                $log.info(jqXHR);
            });
    };
    
    $scope.go = function ( path ) {
        $window.location = path;
    };
    
    //do this when the page loads and the DOM is ready
    angular.element(document).ready(function () {    
        $scope.listAtmServer();
    });
    
}]);

ngAtmList.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});