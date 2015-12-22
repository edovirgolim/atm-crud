<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ING ATM</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
        <script src="${cp}/resources/js/lib/angular.min.js" type="text/javascript"></script>
        <script src="${cp}/resources/js/atm-list.js"></script>
    </head>
    <body ng-app="atm-list">
        <h4>ING ATM</h4>
               
        <div>
            <div ng-controller="ctrl-list" context-path="${cp}">
                <p>
                    <button ng-click="go('./')" >List ATMs From Server</button>
                </p>
                <h2>ATMs List</h2>
                <hr />
                
                <section class="list" ng-repeat="atm in atmServerList | startFrom:currentPage*pageSize | limitTo:pageSize">
                    <label>
                        <span>ATM - {{($index + 1) + (currentPage * 10)}}</span>
                        <hr/>
                    </label>
                    
                    <section class="list">
                        <label>
                            <span>Type</span>
                            <input type="text" ng-model="atm.type" readonly="true"/>
                        </label>
                        
                        <label>
                            <span>Distance</span>
                            <input type="text" ng-model="atm.distance" readonly="true"/>
                        </label>
                        
                        <label>
                            <hr/>
                            <span>Address</span>
                        </label>
                        <section class="list">
                            <label>
                                <span>Street</span>
                                <input type="text" ng-model="atm.address.street" readonly="true"/>
                            </label>
                            <label>
                                <span>House Number</span>
                                <input type="text" ng-model="atm.address.housenumber" readonly="true"/>
                            </label>
                            <label>
                                <span>Postal Code</span>
                                <input type="text" ng-model="atm.address.postalcode" readonly="true"/>
                            </label>
                            <label>
                                <span>City</span>
                                <input type="text" ng-model="atm.address.city" readonly="true"/>
                            </label>
                            
                            <label>
                                <hr/>
                                <span>Geo Location</span>
                            </label>
                            <section class="list">
                                <label>
                                    <span>Latitude</span>
                                    <input type="text" ng-model="atm.address.geoLocation.lat" readonly="true"/>
                                </label>
                                <label>
                                    <span>Longitude</span>
                                    <input type="text" ng-model="atm.address.geoLocation.lng" readonly="true"/>
                                </label>                            
                            </section>
                        </section>
                    </section>
                </section>
                
                <button ng-disabled="currentPage == 0" ng-click="currentPage=currentPage-1">
                    Previous
                </button>
                
                {{currentPage+1}}/{{numberOfPages()}}
                
                <button ng-disabled="currentPage >= atmServerList.length/pageSize - 1" ng-click="currentPage=currentPage+1">
                    Next
                </button>
                
                
                
            </div>
        </div>

    </body>
</html>