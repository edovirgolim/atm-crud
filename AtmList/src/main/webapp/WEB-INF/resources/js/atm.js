var ngAtm = angular.module('atm', []);

ngAtm.controller('ctrl',["$scope","$attrs", "$http", "$window", function($scope, $attrs, $http, $window){
    $scope.atmList = [];
    $scope.msg = "";
    $scope.atmObj = "";
    
    $scope.addATM = function() {
        //$scope.atmList.push({
        $scope.atmObj = {
            address: {
                street: "",
                housenumber: "",
                postalcode: "",
                city: "",
                geoLocation: {
                    lat: "",
                    lng: ""
                }
            },
            distance: "",
            type: ""
        };
    };
    
    $scope.getModel = function() {
        var req = {
            method: 'GET',
            url: $attrs.contextPath  + "/get",
            headers: {
                'Content-Type': 'application/json'
            }
        };

        $http(req).
            success(function(data, status, headers, config){
                console.log(data);
                $scope.atmList = data;
            }).
            error(function(jqXHR, textStatus, errorThrown){
                alert('Woops something wen wrong with the AJAX call');
            });
    };
    
    $scope.listAtmServer = function() {
        var req = {
            method: 'GET',
            url: $attrs.contextPath  + "/list/get",
            headers: {
                'Content-Type': 'application/json'
            }
        };

        $http(req).
            success(function(data, status, headers, config){
                $scope.atmList = data;
            }).
            error(function(jqXHR, textStatus, errorThrown){
                alert('Woops something wen wrong with the AJAX call');
            });
    };
    
    $scope.saveATM = function() {
        alert($attrs.contextPath  + "/save");
        var req = {
            method: "POST",
            url: $attrs.contextPath  + "/save",
            headers: {
                "Content-Type": "application/json"
            },
            data: JSON.stringify({atmObj: $scope.atmObj})
        };

        
        $http(req).
            success(function(data, status, headers, config){
                $scope.msg = data;
                alert($scope.msg.msg);
                $scope.addATM();
                $scope.getModel();
        }).
            error(function(jqXHR, textStatus, errorThrown){
                alert('Woops something wen wrong with the AJAX call');
            });
    };
    
    $scope.go = function ( path ) {
        $window.location = path;
    };
    
    //do this when the page loads and the DOM is ready
    angular.element(document).ready(function () {
        alert('Fetching Loaded ATMs');        
        $scope.getModel();
    });
    
}]);
