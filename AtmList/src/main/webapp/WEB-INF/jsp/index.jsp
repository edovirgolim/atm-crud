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
        <script src="${cp}/resources/js/atm.js"></script>
    </head>
    <body ng-app="atm">
        <h4>ING ATM</h4>
               
        <div>
            <div ng-controller="ctrl" context-path="${cp}">
                <p>
                    <button ng-click="go('list')" >List ATMs From Server</button>
                </p>
                
                <p>
                    <button>Add ATM</button>
                </p>
                
                
                <!--p>
                    <button ng-click="addATM()">Add ATM</button>
                </p-->
                               
                <section class="atm">
                    <label>
                        <span>NEW ATM</span>
                        <hr/>
                    </label>
                    
                    <section class="atm">
                        <label>
                            <span>Type</span>
                            <input type="text" ng-model="atmObj.type" />
                        </label>
                        
                        <label>
                            <span>Distance</span>
                            <input type="text" ng-model="atmObj.distance" />
                        </label>
                        
                        <label>
                            <hr/>
                            <span>Address</span>
                        </label>
                        <section class="atm">
                            <label>
                                <span>Street</span>
                                <input type="text" ng-model="atmObj.address.street" />
                            </label>
                            <label>
                                <span>House Number</span>
                                <input type="text" ng-model="atmObj.address.housenumber" />
                            </label>
                            <label>
                                <span>Postal Code</span>
                                <input type="text" ng-model="atmObj.address.postalcode" />
                            </label>
                            <label>
                                <span>City</span>
                                <input type="text" ng-model="atmObj.address.city" />
                            </label>
                            
                            <label>
                                <hr/>
                                <span>Geo Location</span>
                            </label>
                            <section class="atm">
                                <label>
                                    <span>Latitude</span>
                                    <input type="text" ng-model="atmObj.address.geoLocation.lat" />
                                </label>
                                <label>
                                    <span>Longitude</span>
                                    <input type="text" ng-model="atmObj.address.geoLocation.lng" />
                                </label>                            
                            </section>
                        </section>
                    </section>
                    <p>
                        <button ng-click="saveATM()" ng>Save ATM</button>
                    </p>
                </section>
                
                
                <br />
                <h2>ATMs List</h2>
                <hr />
                
                <section class="list" ng-repeat="atm2 in atmList">
                    <label>
                        <span>ATM List</span>
                        <hr/>
                    </label>
                    
                    <section class="list">
                        <label>
                            <span>Type</span>
                            <input type="text" ng-model="atm2.type" />
                        </label>
                        
                        <label>
                            <span>Distance</span>
                            <input type="text" ng-model="atm2.distance" />
                        </label>
                        
                        <label>
                            <hr/>
                            <span>Address</span>
                        </label>
                        <section class="list">
                            <label>
                                <span>Street</span>
                                <input type="text" ng-model="atm2.address.street" />
                            </label>
                            <label>
                                <span>House Number</span>
                                <input type="text" ng-model="atm2.address.housenumber" />
                            </label>
                            <label>
                                <span>Postal Code</span>
                                <input type="text" ng-model="atm2.address.postalcode" />
                            </label>
                            <label>
                                <span>City</span>
                                <input type="text" ng-model="atm2.address.city" />
                            </label>
                            
                            <label>
                                <hr/>
                                <span>Geo Location</span>
                            </label>
                            <section class="list">
                                <label>
                                    <span>Latitude</span>
                                    <input type="text" ng-model="atm2.address.geoLocation.lat" />
                                </label>
                                <label>
                                    <span>Longitude</span>
                                    <input type="text" ng-model="atm2.address.geoLocation.lng" />
                                </label>                            
                            </section>
                        </section>
                    </section>
                </section>
                
                
                
                
            </div>
        </div>

    </body>
</html>
