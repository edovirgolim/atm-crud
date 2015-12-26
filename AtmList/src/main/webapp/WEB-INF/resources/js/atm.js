var ngAtm = angular.module('atm', []);

ngAtm.controller('ctrl', ["$scope", "$attrs", "$http", "$window", "$log", function ($scope, $attrs, $http, $window, $log) {
        $scope.atmList = [];
        $scope.msg = "";
        $scope.atmObj = "";

        $scope.newATM = function () {
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

        $scope.getModel = function () {
            var req = {
                method: 'GET',
                url: $attrs.contextPath + "/get",
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            $http(req).
                    success(function (data, status, headers, config) {
                        console.log(data);
                        $scope.atmList = data;
                    }).
                    error(function (jqXHR, textStatus, errorThrown) {
                        alert('Woops something wen wrong with the AJAX call');
                    });
        };

        $scope.listAtmServer = function () {
            var req = {
                method: 'GET',
                url: $attrs.contextPath + "/list/get",
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            $http(req).
                    success(function (data, status, headers, config) {
                        $scope.atmList = data;
                    }).
                    error(function (jqXHR, textStatus, errorThrown) {
                        alert('Woops something wen wrong with the AJAX call');
                    });
        };

        $scope.saveATM = function () {
            $scope.showSuccessAlert = false;
            var req = {
                method: "POST",
                url: $attrs.contextPath + "/save",
                headers: {
                    "Content-Type": "application/json", 
                    "X-CSRF-TOKEN": getMetaContentByName('_csrf')
                },
                data: JSON.stringify({atmObj: $scope.atmObj})
            };

            $http(req).
                    success(function (data, status, headers, config) {
                        $scope.msg = data.msg;
                        $scope.showSuccessAlert = true;
                        $scope.newATM();
                        $scope.getModel();
                    }).
                    error(function (jqXHR, textStatus, errorThrown) {
                        $scope.msg = "Something went wrong sending ATM info";
                        $scope.showSuccessAlert = true;
                        $log.info(jqXHR);
                    });
        };

        $scope.go = function (path) {
            $window.location = path;
        };

        //do this when the page loads and the DOM is ready
        angular.element(document).ready(function () {
            $scope.getModel();
            $scope.newATM();
        });

    }]);

function getMetaContentByName(name, content) {
    var content = (content == null) ? 'content' : content;
    return document.querySelector("meta[name='" + name + "']").getAttribute(content);
}