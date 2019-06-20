(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/_model/AmendOrder.ts":
/*!**************************************!*\
  !*** ./src/app/_model/AmendOrder.ts ***!
  \**************************************/
/*! exports provided: AmendOrder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AmendOrder", function() { return AmendOrder; });
var AmendOrder = /** @class */ (function () {
    function AmendOrder() {
    }
    return AmendOrder;
}());



/***/ }),

/***/ "./src/app/_model/CancelOrder.ts":
/*!***************************************!*\
  !*** ./src/app/_model/CancelOrder.ts ***!
  \***************************************/
/*! exports provided: CancelOrder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CancelOrder", function() { return CancelOrder; });
var CancelOrder = /** @class */ (function () {
    function CancelOrder() {
    }
    return CancelOrder;
}());



/***/ }),

/***/ "./src/app/_model/OrdersPerTimeSlice.ts":
/*!**********************************************!*\
  !*** ./src/app/_model/OrdersPerTimeSlice.ts ***!
  \**********************************************/
/*! exports provided: OrdersPerTimeSlice */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrdersPerTimeSlice", function() { return OrdersPerTimeSlice; });
var OrdersPerTimeSlice = /** @class */ (function () {
    function OrdersPerTimeSlice() {
    }
    return OrdersPerTimeSlice;
}());



/***/ }),

/***/ "./src/app/_model/jms.ts":
/*!*******************************!*\
  !*** ./src/app/_model/jms.ts ***!
  \*******************************/
/*! exports provided: JMS */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JMS", function() { return JMS; });
var JMS = /** @class */ (function () {
    function JMS() {
    }
    return JMS;
}());



/***/ }),

/***/ "./src/app/_model/orderParam.ts":
/*!**************************************!*\
  !*** ./src/app/_model/orderParam.ts ***!
  \**************************************/
/*! exports provided: OrderParam */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderParam", function() { return OrderParam; });
var OrderParam = /** @class */ (function () {
    function OrderParam() {
    }
    return OrderParam;
}());



/***/ }),

/***/ "./src/app/_model/user.ts":
/*!********************************!*\
  !*** ./src/app/_model/user.ts ***!
  \********************************/
/*! exports provided: User */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function() { return User; });
var User = /** @class */ (function () {
    function User() {
    }
    return User;
}());



/***/ }),

/***/ "./src/app/_services/authentication.service.ts":
/*!*****************************************************!*\
  !*** ./src/app/_services/authentication.service.ts ***!
  \*****************************************************/
/*! exports provided: AuthenticationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return AuthenticationService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AuthenticationService = /** @class */ (function () {
    function AuthenticationService() {
    }
    AuthenticationService.prototype.authenticate = function (username, password) {
        if ((username === "user1" && password === "password") || (username === "admin" && password === "mubasher")) {
            localStorage.setItem('username', username);
            return true;
        }
        else {
            return false;
        }
    };
    AuthenticationService.prototype.isUserLoggedIn = function () {
        var client = localStorage.getItem('username');
        // console.log(!(client === null))
        return !(client === null);
    };
    AuthenticationService.prototype.logOut = function () {
        localStorage.removeItem('username');
    };
    AuthenticationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AuthenticationService);
    return AuthenticationService;
}());



/***/ }),

/***/ "./src/app/_services/order-service.service.ts":
/*!****************************************************!*\
  !*** ./src/app/_services/order-service.service.ts ***!
  \****************************************************/
/*! exports provided: OrderServiceService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderServiceService", function() { return OrderServiceService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var OrderServiceService = /** @class */ (function () {
    function OrderServiceService(http) {
        this.http = http;
        this.usersUrl = '/params';
    }
    OrderServiceService.prototype.findAll = function () {
        return this.http.get(this.usersUrl);
    };
    OrderServiceService.prototype.save = function (orderParam) {
        return this.http.post(this.usersUrl, orderParam);
    };
    OrderServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], OrderServiceService);
    return OrderServiceService;
}());



/***/ }),

/***/ "./src/app/_services/ordersper-time-slice.service.ts":
/*!***********************************************************!*\
  !*** ./src/app/_services/ordersper-time-slice.service.ts ***!
  \***********************************************************/
/*! exports provided: OrdersperTimeSliceService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrdersperTimeSliceService", function() { return OrdersperTimeSliceService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var OrdersperTimeSliceService = /** @class */ (function () {
    function OrdersperTimeSliceService(http) {
        this.http = http;
        this.usersUrl = '/ordersPerTimeSlice';
    }
    OrdersperTimeSliceService.prototype.findAll = function () {
        return this.http.get(this.usersUrl);
    };
    OrdersperTimeSliceService.prototype.save = function (ordersPerTimeSlice) {
        return this.http.post(this.usersUrl, ordersPerTimeSlice);
    };
    OrdersperTimeSliceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], OrdersperTimeSliceService);
    return OrdersperTimeSliceService;
}());



/***/ }),

/***/ "./src/app/_services/user-service.service.ts":
/*!***************************************************!*\
  !*** ./src/app/_services/user-service.service.ts ***!
  \***************************************************/
/*! exports provided: UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return UserService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var UserService = /** @class */ (function () {
    function UserService(http, router) {
        this.http = http;
        this.router = router;
        this.usersUrl = '/users';
    }
    UserService.prototype.findAll = function () {
        return this.http.get(this.usersUrl);
    };
    UserService.prototype.save = function (user) {
        return this.http.post(this.usersUrl, user);
    };
    UserService.prototype.gotoUserList = function () {
        this.router.navigate(['/users']);
    };
    UserService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], UserService);
    return UserService;
}());



/***/ }),

/***/ "./src/app/amend/amend-order.service.ts":
/*!**********************************************!*\
  !*** ./src/app/amend/amend-order.service.ts ***!
  \**********************************************/
/*! exports provided: AmendOrderService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AmendOrderService", function() { return AmendOrderService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var AmendOrderService = /** @class */ (function () {
    function AmendOrderService(http, router) {
        this.http = http;
        this.router = router;
        this.amendOrdersUrl = '/amendOrder';
        this.cancelOrdersURL = '/cancelOrder';
    }
    AmendOrderService.prototype.save = function (amendOrder) {
        return this.http.post(this.amendOrdersUrl, amendOrder);
    };
    AmendOrderService.prototype.saveCancel = function (cancelOrder) {
        return this.http.post(this.cancelOrdersURL, cancelOrder);
    };
    AmendOrderService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], AmendOrderService);
    return AmendOrderService;
}());



/***/ }),

/***/ "./src/app/amend/amend.component.css":
/*!*******************************************!*\
  !*** ./src/app/amend/amend.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvYW1lbmQvYW1lbmQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/amend/amend.component.html":
/*!********************************************!*\
  !*** ./src/app/amend/amend.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--<app-websocket></app-websocket>-->\n<header class=\"header\">\n  <nav class=\"navbar navbar-expand-lg\">\n    <div class=\"container-fluid d-flex align-items-center justify-content-between\">\n      <div class=\"navbar-header\">\n        <!-- Navbar Header--><a href=\"index.html\" class=\"navbar-brand\">\n        <div class=\"brand-text brand-big visible text-uppercase\"><strong class=\"text-primary\">Order </strong><strong>system</strong></div>\n        <div class=\"brand-text brand-sm\"><strong class=\"text-primary\">D</strong><strong>A</strong></div></a>\n        <!-- Sidebar Toggle Btn-->\n\n\n\n\n\n        <button class=\"sidebar-toggle\"><i class=\"fa fa-long-arrow-left\"></i></button>\n      </div>\n    </div>\n    <!--<div class=\"list-inline-item logout\"> <a *ngIf=\"!loginService.isUserLoggedIn()\" routerLink=\"/login\" class=\"nav-link\"> Login </a> </div>-->\n    <!--<div class=\"list-inline-item logout\"><a *ngIf=\"loginService.isUserLoggedIn()\" routerLink=\"/logout\" class=\"nav-link\">LogOut</a></div>-->\n  </nav>\n</header>\n<div class=\"d-flex align-items-stretch\" >\n  <nav id=\"sidebar\" >\n    <!-- Sidebar Header-->\n\n    <!-- Sidebar Navidation Menus-->\n    <ul class=\"list-unstyled\">\n      <li><a routerLink=\"/users\">Create Orders </a></li>\n      <li><a  routerLink=\"/Amend\"> Amend/Cancel Orders </a></li>\n      <!--<li><a href=\"charts.html\">Cancel Orders </a></li>-->\n      <li><a routerLink=\"/JMS\"> JMS Send</a></li>\n      <!--<li><a href=\"forms.html\"> amendOrder List </a></li>-->\n\n    </ul>\n  </nav>\n  <div class=\"page-content\">\n    <div class=\"page-header\">\n      <div class=\"container-fluid\">\n        <h2 class=\"h5 no-margin-bottom\">Dashboard</h2>\n      </div>\n    </div>\n    <div class=\"row\">\n      <div class=\"col-md-6\">\n        <div class=\"card my-5\">\n          <div class=\"card-body\">\n            <h2>Amend Order</h2><br>\n            <form (ngSubmit)=\"onSubmit()\" #amendOrderForm=\"ngForm\" class=\"form-horizontal\">\n              <div class=\"form-group\">\n                <div class=\"form-group row\">\n                  <label for=\"clOrdID\" class=\"col-sm-3 form-control-label\">ClOrderID</label>\n                  <!--<label for=\"orderChannel\"></label>-->\n                  <div class=\"col-sm-9\">\n                    <input type=\"text\" [(ngModel)]=\"amendOrder && amendOrder.clOrdID\" class=\"form-control\" id=\"clOrdID\"  name =\"clOrdID\"\n                           #clOrdID=\"ngModel\">\n                  </div>\n                </div>\n              </div>\n\n              <div class=\"form-group\">\n                <div class=\"form-group row\">\n                  <label for=\"orderQty\" class=\"col-sm-3 form-control-label\">Order Quantity</label>\n                  <div class=\"col-sm-9\">\n                    <input type=\"number\" [(ngModel)]=\"amendOrder && amendOrder.orderQty\" class=\"form-control\" id=\"orderQty\"  name=\"orderQty\"\n                           required #orderQty=\"ngModel\">\n                  </div>\n                </div>\n              </div>\n\n              <div class=\"form-group\">\n                <div class=\"form-group row\">\n                  <label for=\"price\" class=\"col-sm-3 form-control-label\">Price</label>\n                  <div class=\"col-sm-9\">\n                    <input type=\"text\" [(ngModel)]=\"amendOrder && amendOrder.price\" class=\"form-control\" id=\"price\"  name=\"price\"\n                           required #price=\"ngModel\">\n                  </div>\n                </div>\n              </div>\n              <div class=\"row\">\n                <div class=\"col-md-6\">\n                  <button type=\"submit\" [disabled]=\"!amendOrderForm.form.valid\" (click) =\"order()\" class=\"btn btn-info\">Configure</button>\n                </div>\n                <div class=\"col-md-6\">\n                </div>\n              </div>\n            </form>\n          </div>\n        </div>\n\n\n\n        <div class=\"card my-5\">\n          <div class=\"card-body\">\n            <h2>Cancel Order</h2><br>\n            <form (ngSubmit)=\"onCancel()\" #cancelOrderForm=\"ngForm\" class=\"form-horizontal\">\n              <div class=\"form-group\">\n                <div class=\"form-group row\">\n                  <label for=\"clOrdID\" class=\"col-sm-3 form-control-label\">ClOrderID</label>\n                  <!--<label for=\"orderChannel\"></label>-->\n                  <div class=\"col-sm-9\">\n                    <input type=\"text\" [(ngModel)]=\"cancelOrder && cancelOrder.clOrdID\" class=\"form-control\" id=\"cancelOrder\"  name =\"clOrdID\"\n                           #clOrdID=\"ngModel\">\n                  </div>\n                </div>\n              </div>\n              <div class=\"row\">\n                <div class=\"col-md-6\">\n                  <button type=\"submit\" [disabled]=\"!cancelOrderForm.form.valid\" (click) =\"order()\" class=\"btn btn-info\">Configure</button>\n                </div>\n                <div class=\"col-md-6\">\n                </div>\n              </div>\n            </form>\n          </div>\n        </div>\n\n\n\n\n\n\n      </div>\n      <div class=\"col-md-6\">\n        <br><br>\n        <div class=\"statistic-block block\">\n          <div class=\"progress-details d-flex align-items-end justify-content-between\">\n            <div class=\"title\">\n              <!-- <div class=\"icon\"><i class=\"icon-user-1\"></i></div> -->\n              <strong>Responses</strong>\n            </div>\n          </div>\n\n        </div>\n        <!--<div id=\"scroll\" style=\"overflow-y:scroll; height:400px;\">-->\n        <div id=\"scroll\" style=\"overflow-y:scroll; height:400px;\">\n          <p-table [value]=\"messages\" >\n\n            <ng-template pTemplate=\"header\">\n              <tr>\n                <!--<th>Response</th>-->\n              </tr>\n            </ng-template>\n            <ng-template pTemplate=\"body\" let-message>\n              <tr>\n                <td>{{message}}</td>\n              </tr>\n            </ng-template>\n          </p-table>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/amend/amend.component.ts":
/*!******************************************!*\
  !*** ./src/app/amend/amend.component.ts ***!
  \******************************************/
/*! exports provided: AmendComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AmendComponent", function() { return AmendComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_AmendOrder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../_model/AmendOrder */ "./src/app/_model/AmendOrder.ts");
/* harmony import */ var _amend_order_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./amend-order.service */ "./src/app/amend/amend-order.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _response_response_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../response/response.service */ "./src/app/response/response.service.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _model_CancelOrder__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../_model/CancelOrder */ "./src/app/_model/CancelOrder.ts");









var AmendComponent = /** @class */ (function () {
    function AmendComponent(amendOrderService, router, responseService) {
        this.amendOrderService = amendOrderService;
        this.router = router;
        this.responseService = responseService;
        this.messages = [];
        this.onSubmit = function () {
            var _this = this;
            this.amendOrderService.save(this.amendOrder).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.onCancel = function () {
            var _this = this;
            this.amendOrderService.saveCancel(this.cancelOrder).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.amendOrder = new _model_AmendOrder__WEBPACK_IMPORTED_MODULE_2__["AmendOrder"]();
        this.cancelOrder = new _model_CancelOrder__WEBPACK_IMPORTED_MODULE_8__["CancelOrder"]();
    }
    AmendComponent.prototype.ngOnInit = function () {
    };
    AmendComponent.prototype.gotoUserList = function () {
        this.router.navigate(['/Amend']);
    };
    AmendComponent.prototype.order = function () {
        var _this = this;
        this.responseService.order().subscribe(function (params) {
        });
        this.subscription2 = Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["timer"])(0, 1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["switchMap"])(function () { return _this.responseService.getLastHundredResponses(); })).subscribe(function (data) {
            _this.messages = [];
            for (var i = 0; i < 50; i++) {
                _this.messages.push(data[i]);
            }
        });
    };
    AmendComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-amend',
            template: __webpack_require__(/*! ./amend.component.html */ "./src/app/amend/amend.component.html"),
            styles: [__webpack_require__(/*! ./amend.component.css */ "./src/app/amend/amend.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_amend_order_service__WEBPACK_IMPORTED_MODULE_3__["AmendOrderService"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"], _response_response_service__WEBPACK_IMPORTED_MODULE_5__["ResponseService"]])
    ], AmendComponent);
    return AmendComponent;
}());



/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _user_form_user_form_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./user-form/user-form.component */ "./src/app/user-form/user-form.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./dashboard/dashboard.component */ "./src/app/dashboard/dashboard.component.ts");
/* harmony import */ var _register_register_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./register/register.component */ "./src/app/register/register.component.ts");
/* harmony import */ var _logout_logout_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./logout/logout.component */ "./src/app/logout/logout.component.ts");
/* harmony import */ var _params_params_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./params/params.component */ "./src/app/params/params.component.ts");
/* harmony import */ var _jms_jms_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./jms/jms.component */ "./src/app/jms/jms.component.ts");
/* harmony import */ var _amend_amend_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./amend/amend.component */ "./src/app/amend/amend.component.ts");











var routes = [
    { path: 'users', component: _dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_5__["DashboardComponent"] },
    { path: 'start', component: _user_form_user_form_component__WEBPACK_IMPORTED_MODULE_3__["UserFormComponent"] },
    { path: 'login', component: _login_login_component__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"] },
    { path: 'register', component: _register_register_component__WEBPACK_IMPORTED_MODULE_6__["RegisterComponent"] },
    { path: '', component: _login_login_component__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"] },
    { path: 'logout', component: _logout_logout_component__WEBPACK_IMPORTED_MODULE_7__["LogoutComponent"] },
    { path: 'params', component: _params_params_component__WEBPACK_IMPORTED_MODULE_8__["ParamsComponent"] },
    { path: 'JMS', component: _jms_jms_component__WEBPACK_IMPORTED_MODULE_9__["JMSComponent"] },
    { path: 'Amend', component: _amend_amend_component__WEBPACK_IMPORTED_MODULE_10__["AmendComponent"] },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n\r\n.card bg-dark my-5{\r\n    padding: 0px;\r\n}.card-body{\r\n    padding-top: 0px;\r\n}.row{\r\n    padding-top: 0px;\r\n}.page-header{\r\n    margin-bottom: 0px;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9hcHAuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOztBQUVBO0lBQ0ksWUFBWTtBQUNoQixDQUFDO0lBQ0csZ0JBQWdCO0FBQ3BCLENBQUM7SUFDRyxnQkFBZ0I7QUFDcEIsQ0FBQztJQUNHLGtCQUFrQjtBQUN0QiIsImZpbGUiOiJhcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi5jYXJkIGJnLWRhcmsgbXktNXtcclxuICAgIHBhZGRpbmc6IDBweDtcclxufS5jYXJkLWJvZHl7XHJcbiAgICBwYWRkaW5nLXRvcDogMHB4O1xyXG59LnJvd3tcclxuICAgIHBhZGRpbmctdG9wOiAwcHg7XHJcbn0ucGFnZS1oZWFkZXJ7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAwcHg7XHJcbn1cclxuIl19 */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _response_response_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./response/response.service */ "./src/app/response/response.service.ts");



var AppComponent = /** @class */ (function () {
    function AppComponent(responseService) {
        this.responseService = responseService;
        this.title = 'ang-app';
        this.responseService.connect().subscribe();
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_response_response_service__WEBPACK_IMPORTED_MODULE_2__["ResponseService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var primeng_table__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! primeng/table */ "./node_modules/primeng/table.js");
/* harmony import */ var primeng_table__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(primeng_table__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _user_form_user_form_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./user-form/user-form.component */ "./src/app/user-form/user-form.component.ts");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _services_user_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./_services/user-service.service */ "./src/app/_services/user-service.service.ts");
/* harmony import */ var _response_response_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./response/response.component */ "./src/app/response/response.component.ts");
/* harmony import */ var angular2_virtual_scroll__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! angular2-virtual-scroll */ "./node_modules/angular2-virtual-scroll/dist/virtual-scroll.js");
/* harmony import */ var angular2_virtual_scroll__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(angular2_virtual_scroll__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/esm5/scrolling.es5.js");
/* harmony import */ var ngx_infinite_scroll__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ngx-infinite-scroll */ "./node_modules/ngx-infinite-scroll/modules/ngx-infinite-scroll.es5.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./dashboard/dashboard.component */ "./src/app/dashboard/dashboard.component.ts");
/* harmony import */ var _register_register_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./register/register.component */ "./src/app/register/register.component.ts");
/* harmony import */ var _logout_logout_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./logout/logout.component */ "./src/app/logout/logout.component.ts");
/* harmony import */ var _params_params_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./params/params.component */ "./src/app/params/params.component.ts");
/* harmony import */ var _jms_jms_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./jms/jms.component */ "./src/app/jms/jms.component.ts");
/* harmony import */ var _amend_amend_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./amend/amend.component */ "./src/app/amend/amend.component.ts");






















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _user_form_user_form_component__WEBPACK_IMPORTED_MODULE_6__["UserFormComponent"],
                _response_response_component__WEBPACK_IMPORTED_MODULE_10__["ResponseComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_15__["LoginComponent"],
                _dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_16__["DashboardComponent"],
                _register_register_component__WEBPACK_IMPORTED_MODULE_17__["RegisterComponent"],
                _logout_logout_component__WEBPACK_IMPORTED_MODULE_18__["LogoutComponent"],
                _params_params_component__WEBPACK_IMPORTED_MODULE_19__["ParamsComponent"],
                _jms_jms_component__WEBPACK_IMPORTED_MODULE_20__["JMSComponent"],
                _amend_amend_component__WEBPACK_IMPORTED_MODULE_21__["AmendComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_7__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormsModule"],
                angular2_virtual_scroll__WEBPACK_IMPORTED_MODULE_11__["VirtualScrollModule"],
                _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_12__["ScrollingModule"],
                ngx_infinite_scroll__WEBPACK_IMPORTED_MODULE_13__["InfiniteScrollModule"],
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_7__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                ng2_file_upload__WEBPACK_IMPORTED_MODULE_14__["FileUploadModule"],
                primeng_table__WEBPACK_IMPORTED_MODULE_3__["TableModule"]
            ],
            providers: [_services_user_service_service__WEBPACK_IMPORTED_MODULE_9__["UserService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/dashboard/dashboard.component.css":
/*!***************************************************!*\
  !*** ./src/app/dashboard/dashboard.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvZGFzaGJvYXJkL2Rhc2hib2FyZC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/dashboard/dashboard.component.html":
/*!****************************************************!*\
  !*** ./src/app/dashboard/dashboard.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--<app-websocket></app-websocket>-->\n<header class=\"header\">\n  <nav class=\"navbar navbar-expand-lg\">\n    <div class=\"container-fluid d-flex align-items-center justify-content-between\">\n      <div class=\"navbar-header\">\n        <!-- Navbar Header--><a href=\"index.html\" class=\"navbar-brand\">\n        <div class=\"brand-text brand-big visible text-uppercase\"><strong class=\"text-primary\">Order </strong><strong>system</strong></div>\n        <div class=\"brand-text brand-sm\"><strong class=\"text-primary\">D</strong><strong>A</strong></div></a>\n        <!-- Sidebar Toggle Btn-->\n\n\n\n\n\n        <button class=\"sidebar-toggle\"><i class=\"fa fa-long-arrow-left\"></i></button>\n      </div>\n    </div>\n    <div class=\"list-inline-item logout\"> <a *ngIf=\"!loginService.isUserLoggedIn()\" routerLink=\"/login\" class=\"nav-link\"> Login </a> </div>\n    <div class=\"list-inline-item logout\"><a *ngIf=\"loginService.isUserLoggedIn()\" routerLink=\"/logout\" class=\"nav-link\">LogOut</a></div>\n  </nav>\n</header>\n<div class=\"d-flex align-items-stretch\" >\n  <nav id=\"sidebar\" >\n    <!-- Sidebar Header-->\n\n    <!-- Sidebar Navidation Menus-->\n    <ul class=\"list-unstyled\">\n      <li><a routerLink=\"/users\">Create Orders </a></li>\n      <li><a  routerLink=\"/Amend\"> Amend/Cancel Orders </a></li>\n      <li><a routerLink=\"/JMS\"> JMS Send</a></li>\n    </ul>\n  </nav>\n  <div class=\"page-content\">\n    <div class=\"page-header\">\n      <div class=\"container-fluid\">\n        <h2 class=\"h5 no-margin-bottom\">Dashboard</h2>\n      </div>\n    </div>\n    <div class=\"row\">\n      <div class=\"col-md-6\">\n        <app-user-form></app-user-form>\n        <app-params></app-params>\n      </div>\n      <div class=\"col-md-6\">\n        <div class=\"row\">\n          <div class=\"col-md-12\">\n            <div class=\"card-body\">\n              <app-response></app-response>\n            </div>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "./src/app/dashboard/dashboard.component.ts":
/*!**************************************************!*\
  !*** ./src/app/dashboard/dashboard.component.ts ***!
  \**************************************************/
/*! exports provided: DashboardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DashboardComponent", function() { return DashboardComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../_services/authentication.service */ "./src/app/_services/authentication.service.ts");



var DashboardComponent = /** @class */ (function () {
    function DashboardComponent(loginService) {
        this.loginService = loginService;
    }
    DashboardComponent.prototype.ngOnInit = function () {
    };
    DashboardComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-dashboard',
            template: __webpack_require__(/*! ./dashboard.component.html */ "./src/app/dashboard/dashboard.component.html"),
            styles: [__webpack_require__(/*! ./dashboard.component.css */ "./src/app/dashboard/dashboard.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]])
    ], DashboardComponent);
    return DashboardComponent;
}());



/***/ }),

/***/ "./src/app/jms/jms.component.css":
/*!***************************************!*\
  !*** ./src/app/jms/jms.component.css ***!
  \***************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvam1zL2ptcy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/jms/jms.component.html":
/*!****************************************!*\
  !*** ./src/app/jms/jms.component.html ***!
  \****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--<app-websocket></app-websocket>-->\n<header class=\"header\">\n  <nav class=\"navbar navbar-expand-lg\">\n    <div class=\"container-fluid d-flex align-items-center justify-content-between\">\n      <div class=\"navbar-header\">\n        <!-- Navbar Header--><a href=\"index.html\" class=\"navbar-brand\">\n        <div class=\"brand-text brand-big visible text-uppercase\"><strong class=\"text-primary\">Order </strong><strong>system</strong></div>\n        <div class=\"brand-text brand-sm\"><strong class=\"text-primary\">D</strong><strong>A</strong></div></a>\n        <!-- Sidebar Toggle Btn-->\n        <button class=\"sidebar-toggle\"><i class=\"fa fa-long-arrow-left\"></i></button>\n      </div>\n    </div>\n    <!--<div class=\"list-inline-item logout\"> <a *ngIf=\"!loginService.isUserLoggedIn()\" routerLink=\"/login\" class=\"nav-link\"> Login </a> </div>-->\n    <!--<div class=\"list-inline-item logout\"><a *ngIf=\"loginService.isUserLoggedIn()\" routerLink=\"/logout\" class=\"nav-link\">LogOut</a></div>-->\n  </nav>\n</header>\n<div class=\"d-flex align-items-stretch\" >\n  <nav id=\"sidebar\" >\n    <!-- Sidebar Header-->\n    <!-- Sidebar Navidation Menus-->\n    <ul class=\"list-unstyled\">\n      <li><a  routerLink=\"/users\">Create Orders </a></li>\n      <li><a  routerLink=\"/Amend\"> Amend/Cancel Orders </a></li>\n      <li><a routerLink=\"/JMS\"> JMS Send</a></li>\n      <!--<li><a href=\"forms.html\"> OrderParam List </a></li>-->\n    </ul>\n  </nav>\n  <div class=\"page-content\">\n    <div class=\"page-header\">\n      <div class=\"container-fluid\">\n        <h2 class=\"h5 no-margin-bottom\">Dashboard</h2>\n      </div>\n    </div>\n\n    <input #fileInput type=\"file\" ng2FileSelect [uploader]=\"uploader\"/>\n      <form (ngSubmit)=\"onSubmit()\" #jmsForm=\"ngForm\" class=\"form-horizontal\" >\n        <div> <br>\n        <select id=\"select-type-basic\" [(ngModel)]=\"jms && jms.exchange\" name = \"exchange\" [value]= exchange_values[0] >\n          <option *ngFor=\"let exchange_type of exchange_values\">\n            {{exchange_type}}\n          </option>\n        </select>\n        </div>\n        <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <div class=\"col-sm-9\">\n            <label for=\"jmsMessage\" class=\"col-sm-3 form-control-label\"></label>\n            <input type=\"text\" [(ngModel)]=\"jms && jms.jmsMessage\" class=\"form-control\" name =\"jmsMessage\" id=\"jmsMessage\" #jmsMessage=\"ngModel\">\n          </div>\n        </div>\n        </div>\n        <button type=\"submit\" class=\"btn btn-primary\">Send JMS</button>&nbsp;&nbsp;\n        <button (click)=\"clear()\" class=\"btn btn-secondary\">Clear</button>\n      </form>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "./src/app/jms/jms.component.ts":
/*!**************************************!*\
  !*** ./src/app/jms/jms.component.ts ***!
  \**************************************/
/*! exports provided: JMSComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JMSComponent", function() { return JMSComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _jms_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./jms.service */ "./src/app/jms/jms.service.ts");
/* harmony import */ var _model_jms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../_model/jms */ "./src/app/_model/jms.ts");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_5__);






var JMSComponent = /** @class */ (function () {
    function JMSComponent(route, router, jmsService) {
        this.route = route;
        this.router = router;
        this.jmsService = jmsService;
        this.selectedOption = "FormExchange";
        this.exchange_values = ["FromExchange", "ToExchange"];
        this.onSubmit = function () {
            var _this = this;
            this.jmsService.save(this.jms).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.jms = new _model_jms__WEBPACK_IMPORTED_MODULE_4__["JMS"]();
        this.jms.jmsMessage = "TDWL\u001C0\u001C23041\u001C8=FIXT.1.1\u00019=115\u000135=U29\u000134=316\u000152=20171228-08:06:49.594\u000149=998\u000156=080\u000157=M0800001\u00019742=U2815360521\u00019730=0\u00019701=180904000000263\u00019729=1365245876\u0001900=5\u000110=124\u0001";
        this.jms.exchange = "FromExchange";
    }
    JMSComponent.prototype.ngOnInit = function () {
        var headers = [{ name: 'Accept', value: 'application/json' }];
        this.uploader = new ng2_file_upload__WEBPACK_IMPORTED_MODULE_5__["FileUploader"]({ url: '/api/files/jms', autoUpload: true, headers: headers });
        this.uploader.onCompleteAll = function () { return alert('File uploaded'); };
    };
    JMSComponent.prototype.gotoUserList = function () {
        this.router.navigate(['/JMS']);
    };
    JMSComponent.prototype.clear = function () {
        this.jms.jmsMessage = null;
    };
    JMSComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-jms',
            template: __webpack_require__(/*! ./jms.component.html */ "./src/app/jms/jms.component.html"),
            styles: [__webpack_require__(/*! ./jms.component.css */ "./src/app/jms/jms.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _jms_service__WEBPACK_IMPORTED_MODULE_3__["JmsService"]])
    ], JMSComponent);
    return JMSComponent;
}());



/***/ }),

/***/ "./src/app/jms/jms.service.ts":
/*!************************************!*\
  !*** ./src/app/jms/jms.service.ts ***!
  \************************************/
/*! exports provided: JmsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JmsService", function() { return JmsService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var JmsService = /** @class */ (function () {
    function JmsService(http) {
        this.http = http;
        this.usersUrl = '/jmsSend';
    }
    JmsService.prototype.findAll = function () {
        return this.http.get(this.usersUrl);
    };
    JmsService.prototype.save = function (jms) {
        return this.http.post(this.usersUrl, jms);
    };
    JmsService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], JmsService);
    return JmsService;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvbG9naW4vbG9naW4uY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"login-page\">\n  <div class=\"container d-flex align-items-center\">\n    <div class=\"form-holder has-shadow\">\n      <div class=\"row\">\n        <!-- Logo & Information Panel-->\n        <div class=\"col-lg-6\">\n          <div class=\"info d-flex align-items-center\">\n            <div class=\"content\">\n              <div class=\"logo\">\n                <h1>Test Client Order System</h1>\n              </div>\n              <!--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>-->\n            </div>\n          </div>\n        </div>\n        <!-- Form Panel    -->\n        <div class=\"col-lg-6\">\n          <div class=\"form d-flex align-items-center\">\n            <div class=\"content\">\n              <form method=\"get\" class=\"form-validate mb-4\">\n                <div class=\"form-group\">\n                  <input id=\"login-username\" type=\"text\" name=\"username\" required data-msg=\"Please enter your username\" class=\"input-material\" [(ngModel)]=\"username\"/>\n                  <label for=\"login-username\" class=\"label-material\"></label>\n                </div>\n                <div class=\"form-group\">\n                  <input id=\"login-password\" type=\"password\" name=\"password\" required data-msg=\"Please enter your password\" class=\"input-material\" [(ngModel)]=\"password\">\n                  <label for=\"login-password\" class=\"label-material\"></label>\n                </div>\n                <button type=\"submit\" (click)=checkLogin() class=\"btn btn-primary\">Login</button>\n              </form><a href=\"#\" class=\"forgot-pass\">Forgot Password?</a><br><small>Do not have an account? </small><a href=\"/register\" class=\"signup\">Signup</a>\n            </div>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../_services/authentication.service */ "./src/app/_services/authentication.service.ts");




var LoginComponent = /** @class */ (function () {
    function LoginComponent(router, loginservice) {
        this.router = router;
        this.loginservice = loginservice;
        this.password = '';
        this.invalidLogin = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.checkLogin = function () {
        if (this.loginservice.authenticate(this.username, this.password)) {
            this.router.navigate(['/users']);
            this.invalidLogin = false;
        }
        else
            this.invalidLogin = true;
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            _services_authentication_service__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/logout/logout.component.css":
/*!*********************************************!*\
  !*** ./src/app/logout/logout.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvbG9nb3V0L2xvZ291dC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/logout/logout.component.html":
/*!**********************************************!*\
  !*** ./src/app/logout/logout.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  logout works!\n</p>\n"

/***/ }),

/***/ "./src/app/logout/logout.component.ts":
/*!********************************************!*\
  !*** ./src/app/logout/logout.component.ts ***!
  \********************************************/
/*! exports provided: LogoutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LogoutComponent", function() { return LogoutComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../_services/authentication.service */ "./src/app/_services/authentication.service.ts");




var LogoutComponent = /** @class */ (function () {
    function LogoutComponent(authentocationService, router) {
        this.authentocationService = authentocationService;
        this.router = router;
    }
    LogoutComponent.prototype.ngOnInit = function () {
        this.authentocationService.logOut();
        this.router.navigate(['login']);
    };
    LogoutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-logout',
            template: __webpack_require__(/*! ./logout.component.html */ "./src/app/logout/logout.component.html"),
            styles: [__webpack_require__(/*! ./logout.component.css */ "./src/app/logout/logout.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_authentication_service__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], LogoutComponent);
    return LogoutComponent;
}());



/***/ }),

/***/ "./src/app/params/params.component.css":
/*!*********************************************!*\
  !*** ./src/app/params/params.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvcGFyYW1zL3BhcmFtcy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/params/params.component.html":
/*!**********************************************!*\
  !*** ./src/app/params/params.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<div class=\"card my-5\">\n  <div class=\"card-body\">\n    <form (ngSubmit)=\"onSubmit()\" #orderParamForm=\"ngForm\" class=\"form-horizontal\">\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"orderChannel\" class=\"col-sm-3 form-control-label\">Order Channel</label>\n          <!--<label for=\"orderChannel\"></label>-->\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.orderChannel\" class=\"form-control\" id=\"orderChannel\"  name =\"orderChannel\" (change)=\"onSubmit()\"\n                   #orderChannel=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n        <label for=\"price\" class=\"col-sm-3 form-control-label\">Price</label>\n          <div class=\"col-sm-9\">\n           <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.price\" class=\"form-control\" id=\"price\"  name=\"price\" (change)=\"onSubmit()\"\n               required #stringPrice=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"type\" class=\"col-sm-3 form-control-label\">Type</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.type\" class=\"form-control\" id=\"type\"  name=\"type\" (change)=\"onSubmit()\"\n                   required #type=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"symbol\" class=\"col-sm-3 form-control-label\">Symbol</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.symbol\" class=\"form-control\" id=\"symbol\"  name=\"symbol\" (change)=\"onSubmit()\"\n                   required #symbol=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"tenantCode\" class=\"col-sm-3 form-control-label\">Tenant Code</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.tenantCode\" class=\"form-control\" id=\"tenantCode\"  name=\"tenantCode\" (change)=\"onSubmit()\"\n                   required #tenantCode=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"marketCode\" class=\"col-sm-3 form-control-label\">Market Code</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.marketCode\" class=\"form-control\" id=\"marketCode\"  name=\"marketCode\" (change)=\"onSubmit()\"\n                   required #marketCode=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"exchange\" class=\"col-sm-3 form-control-label\">Exchange</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.exchange\" class=\"form-control\" id=\"exchange\"  name=\"exchange\" (change)=\"onSubmit()\"\n                   required #exchange=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"side\" class=\"col-sm-3 form-control-label\">Side</label>\n          <div class=\"col-sm-9\">\n            <input type=\"number\" [(ngModel)]=\"orderParam && orderParam.side\" class=\"form-control\" id=\"side\"  name=\"side\" (change)=\"onSubmit()\"\n                   required #side=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"orderMode\" class=\"col-sm-3 form-control-label\">Order Mode</label>\n          <div class=\"col-sm-9\">\n            <input type=\"number\" [(ngModel)]=\"orderParam && orderParam.orderMode\" class=\"form-control\" id=\"orderMode\"  name=\"orderMode\" (change)=\"onSubmit()\"\n                   required #orderMode=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n      <div class=\"form-group\">\n        <div class=\"form-group row\">\n          <label for=\"dealerID\" class=\"col-sm-3 form-control-label\">Dealer ID</label>\n          <div class=\"col-sm-9\">\n            <input type=\"text\" [(ngModel)]=\"orderParam && orderParam.dealerID\" class=\"form-control\" id=\"dealerID\"  name=\"dealerID\" (change)=\"onSubmit()\"\n                   required #dealerID=\"ngModel\">\n          </div>\n        </div>\n      </div>\n\n\n\n\n      <div class=\"row\">\n        <div class=\"col-md-6\">\n\n          <button type=\"submit\" [disabled]=\"!orderParamForm.form.valid\" class=\"btn btn-info\">Configure</button>\n        </div>\n        <div class=\"col-md-6\">\n\n\n        </div>\n      </div>\n\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/params/params.component.ts":
/*!********************************************!*\
  !*** ./src/app/params/params.component.ts ***!
  \********************************************/
/*! exports provided: ParamsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ParamsComponent", function() { return ParamsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_orderParam__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../_model/orderParam */ "./src/app/_model/orderParam.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_order_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../_services/order-service.service */ "./src/app/_services/order-service.service.ts");





var ParamsComponent = /** @class */ (function () {
    function ParamsComponent(route, router, orderService) {
        this.route = route;
        this.router = router;
        this.orderService = orderService;
        this.onSubmit = function () {
            var _this = this;
            this.orderService.save(this.orderParam).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.orderParam = new _model_orderParam__WEBPACK_IMPORTED_MODULE_2__["OrderParam"]();
        //this.orderParam.unReqId = 1011;
        this.orderParam.tenantCode = "DEFAULT_TENANT";
        this.orderParam.symbol = "1010";
        this.orderParam.exchange = 'TDWL';
        this.orderParam.price = 5.0;
        this.orderParam.orderChannel = 12;
        this.orderParam.marketCode = "ALL";
        this.orderParam.type = 2;
        this.orderParam.side = 1;
        this.orderParam.orderMode = 0;
        this.orderParam.dealerID = '1';
    }
    ParamsComponent.prototype.ngOnInit = function () {
        this.onSubmit();
    };
    ParamsComponent.prototype.gotoUserList = function () {
        this.router.navigate(['/users']);
    };
    ParamsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-params',
            template: __webpack_require__(/*! ./params.component.html */ "./src/app/params/params.component.html"),
            styles: [__webpack_require__(/*! ./params.component.css */ "./src/app/params/params.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"], _services_order_service_service__WEBPACK_IMPORTED_MODULE_4__["OrderServiceService"]])
    ], ParamsComponent);
    return ParamsComponent;
}());



/***/ }),

/***/ "./src/app/register/register.component.css":
/*!*************************************************!*\
  !*** ./src/app/register/register.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAvcmVnaXN0ZXIvcmVnaXN0ZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/register/register.component.html":
/*!**************************************************!*\
  !*** ./src/app/register/register.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  register works!\n</p>\n"

/***/ }),

/***/ "./src/app/register/register.component.ts":
/*!************************************************!*\
  !*** ./src/app/register/register.component.ts ***!
  \************************************************/
/*! exports provided: RegisterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RegisterComponent", function() { return RegisterComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var RegisterComponent = /** @class */ (function () {
    function RegisterComponent() {
    }
    RegisterComponent.prototype.ngOnInit = function () {
    };
    RegisterComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-register',
            template: __webpack_require__(/*! ./register.component.html */ "./src/app/register/register.component.html"),
            styles: [__webpack_require__(/*! ./register.component.css */ "./src/app/register/register.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], RegisterComponent);
    return RegisterComponent;
}());



/***/ }),

/***/ "./src/app/response/response.component.css":
/*!*************************************************!*\
  !*** ./src/app/response/response.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "body {\r\n    margin: 0;\r\n    font-size: 28px;\r\n    font-family: Arial, Helvetica, sans-serif;\r\n  }\r\n  \r\n  .header {\r\n    position: fixed;\r\n    top: 0;\r\n    z-index: 1;\r\n    width: 100%;\r\n    background-color: #f1f1f1;\r\n  }\r\n  \r\n  .header h2 {\r\n    text-align: center;\r\n  }\r\n  \r\n  .progress-container {\r\n    width: 100%;\r\n    height: 8px;\r\n    background: #ccc;\r\n    \r\n  }\r\n  \r\n  .progress-bar {\r\n    height: 8px;\r\n    background: #4caf50;\r\n    width: 0%;\r\n  }\r\n  \r\n  .content {\r\n    padding: 100px 0;\r\n    margin: 50px auto 0 auto;\r\n    width: 80%;\r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9yZXNwb25zZS9yZXNwb25zZS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksU0FBUztJQUNULGVBQWU7SUFDZix5Q0FBeUM7RUFDM0M7O0VBRUE7SUFDRSxlQUFlO0lBQ2YsTUFBTTtJQUNOLFVBQVU7SUFDVixXQUFXO0lBQ1gseUJBQXlCO0VBQzNCOztFQUVBO0lBQ0Usa0JBQWtCO0VBQ3BCOztFQUVBO0lBQ0UsV0FBVztJQUNYLFdBQVc7SUFDWCxnQkFBZ0I7O0VBRWxCOztFQUVBO0lBQ0UsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixTQUFTO0VBQ1g7O0VBRUE7SUFDRSxnQkFBZ0I7SUFDaEIsd0JBQXdCO0lBQ3hCLFVBQVU7RUFDWiIsImZpbGUiOiJhcHAvcmVzcG9uc2UvcmVzcG9uc2UuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbImJvZHkge1xyXG4gICAgbWFyZ2luOiAwO1xyXG4gICAgZm9udC1zaXplOiAyOHB4O1xyXG4gICAgZm9udC1mYW1pbHk6IEFyaWFsLCBIZWx2ZXRpY2EsIHNhbnMtc2VyaWY7XHJcbiAgfVxyXG4gIFxyXG4gIC5oZWFkZXIge1xyXG4gICAgcG9zaXRpb246IGZpeGVkO1xyXG4gICAgdG9wOiAwO1xyXG4gICAgei1pbmRleDogMTtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2YxZjFmMTtcclxuICB9XHJcbiAgXHJcbiAgLmhlYWRlciBoMiB7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgfVxyXG4gIFxyXG4gIC5wcm9ncmVzcy1jb250YWluZXIge1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBoZWlnaHQ6IDhweDtcclxuICAgIGJhY2tncm91bmQ6ICNjY2M7XHJcbiAgICBcclxuICB9XHJcbiAgXHJcbiAgLnByb2dyZXNzLWJhciB7XHJcbiAgICBoZWlnaHQ6IDhweDtcclxuICAgIGJhY2tncm91bmQ6ICM0Y2FmNTA7XHJcbiAgICB3aWR0aDogMCU7XHJcbiAgfVxyXG4gIFxyXG4gIC5jb250ZW50IHtcclxuICAgIHBhZGRpbmc6IDEwMHB4IDA7XHJcbiAgICBtYXJnaW46IDUwcHggYXV0byAwIGF1dG87XHJcbiAgICB3aWR0aDogODAlO1xyXG4gIH0iXX0= */"

/***/ }),

/***/ "./src/app/response/response.component.html":
/*!**************************************************!*\
  !*** ./src/app/response/response.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<br>\n<div class=\"stats-3-block block d-flex\">\n        <div class=\"stats-3\"><strong class=\"d-block\">{{this.totalNoOfOrders}}</strong><span class=\"d-block\">Total Requests</span>\n          <!-- <div class=\"progress progress-template progress-small\">\n            <div role=\"progressbar\" style=\"width: 35%;\" aria-valuenow=\"30\" aria-valuemin=\"0\" aria-valuemax=\"100\" class=\"progress-bar progress-bar-template progress-bar-small dashbg-1\"></div>\n          </div> -->\n        </div>\n        <div class=\"stats-3 d-flex justify-content-between text-center\">\n          <div class=\"item\"><strong class=\"d-block strong-sm\">{{this.responseTime}}</strong><span class=\"d-block span-sm\">Time(s)</span>\n            <!-- <div class=\"line\"></div><small>+246</small> -->\n          </div>\n          <div class=\"item\"><strong class=\"d-block strong-sm\">{{this.totalNoOfOrders-this.responseCount}}</strong><span class=\"d-block span-sm\">Pending</span>\n            <!-- <div class=\"line\"></div><small>+416</small> -->\n          </div>\n        </div>\n      </div>\n\n<div class=\"statistic-block block\">\n    <div class=\"progress-details d-flex align-items-end justify-content-between\">\n      <div class=\"title\">\n        <!-- <div class=\"icon\"><i class=\"icon-user-1\"></i></div> -->\n        <strong>Responses</strong>\n      </div>\n      <div class=\"number dashtext-1\">{{this.responseCount}}</div>\n    </div>\n    <div class=\"progress progress-template\">\n        <div role=\"progressbar\" [style.width]=\"this.percentage + '%'\" aria-valuenow=\"55\" aria-valuemin=\"0\" aria-valuemax=\"100\" class=\"progress-bar progress-bar-template dashbg-3\"></div>\n    </div>\n  </div>\n<button type=\"submit\" value=\"Click\" class=\"btn btn-info\" (click) =\"connect()\">Reconnect</button>&nbsp;&nbsp;\n<button type=\"submit\" value=\"Click\" class=\"btn btn-info\" (click) =\"order()\">Place Order</button>&nbsp;&nbsp;\n<button type=\"submit\" value=\"Click\" class=\"btn btn-info\" (click) =\"clear()\">Clear</button>\n<div><br></div>\n\n<div id=\"scroll\" style=\"overflow-y:scroll; height:400px;\">\n<p-table [value]=\"messages\" >\n\n    <ng-template pTemplate=\"header\">\n      <tr>\n        <th>Response</th>\n      </tr>\n    </ng-template>\n    <ng-template pTemplate=\"body\" let-message>\n      <tr>\n        <td>{{message}}</td>\n      </tr>\n    </ng-template>\n\n  </p-table>\n</div>\n"

/***/ }),

/***/ "./src/app/response/response.component.ts":
/*!************************************************!*\
  !*** ./src/app/response/response.component.ts ***!
  \************************************************/
/*! exports provided: ResponseComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResponseComponent", function() { return ResponseComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _response_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./response.service */ "./src/app/response/response.service.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _model_user__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../_model/user */ "./src/app/_model/user.ts");
/* harmony import */ var _services_user_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../_services/user-service.service */ "./src/app/_services/user-service.service.ts");







var ResponseComponent = /** @class */ (function () {
    function ResponseComponent(responseService, userService) {
        this.responseService = responseService;
        this.userService = userService;
        this.messages = [];
        this.responseCountArray = [];
        this.columnDefs = [
            { headerName: 'Response', field: 'response' }
        ];
        this.fetchData$ = this.responseService.getReponseCount();
        //this.getResponseCount();
        this.user = new _model_user__WEBPACK_IMPORTED_MODULE_5__["User"]();
    }
    ResponseComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.responseCountArray = [];
        this.responseCount = 0;
        this.responseTime = 0;
        this.totalNoOfOrders = 0;
        this.userService.findAll().subscribe(function (data) {
            _this.users = data;
            _this.totalNoOfOrders = _this.users[_this.users.length - 1].noOfOrders;
        });
        this.subscription1 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 200).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getReponseCount(); })).subscribe(function (data) {
            _this.responseCount = data;
            _this.percentage = (_this.responseCount / _this.totalNoOfOrders) * 100;
            if (_this.responseCountArray.length < 12) {
                _this.responseCountArray.push(_this.responseCount);
            }
            else {
                _this.responseCountArray.splice(0, 1);
                _this.responseCountArray.push(_this.responseCount);
            }
            if (_this.responseCountArray[0] == _this.responseCountArray[10] || _this.responseCountArray[10] == _this.totalNoOfOrders) {
                // this.subscription1.unsubscribe();
                // this.subscription2.unsubscribe();
                // this.subscription3.unsubscribe();
            }
        });
        this.subscription2 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getLastHundredResponses(); })).subscribe(function (data) {
            _this.messages = [];
            for (var i = 0; i < 50; i++) {
                _this.messages.push(data[i]);
            }
        });
        this.subscription3 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getReponseTime(); })).subscribe(function (data) {
            if (_this.responseCount == 0) {
                _this.responseTime = 0;
            }
            _this.responseTime = data[_this.responseCount - 1] / 1000;
        });
    };
    ResponseComponent.prototype.order = function () {
        var _this = this;
        this.responseCountArray = [];
        this.responseCount = 0;
        this.responseTime = 0;
        this.userService.findAll().subscribe(function (data) {
            _this.users = data;
            _this.totalNoOfOrders = _this.users[_this.users.length - 1].noOfOrders;
        });
        this.responseService.order().subscribe(function (params) {
            // this.populateRowData();
        });
        this.subscription1 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 200).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getReponseCount(); })).subscribe(function (data) {
            _this.responseCount = data;
            _this.percentage = (_this.responseCount / _this.totalNoOfOrders) * 100;
            if (_this.responseCountArray.length < 12) {
                _this.responseCountArray.push(_this.responseCount);
            }
            else {
                _this.responseCountArray.splice(0, 1);
                _this.responseCountArray.push(_this.responseCount);
            }
            if (_this.responseCountArray[0] == _this.responseCountArray[10] || _this.responseCountArray[10] == _this.totalNoOfOrders) {
                // this.subscription1.unsubscribe();
                // this.subscription2.unsubscribe();
                // this.subscription3.unsubscribe();
            }
        });
        this.subscription2 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getLastHundredResponses(); })).subscribe(function (data) {
            _this.messages = [];
            for (var i = 0; i < 50; i++) {
                _this.messages.push(data[i]);
            }
        });
        this.subscription3 = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["timer"])(0, 1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["switchMap"])(function () { return _this.responseService.getReponseTime(); })).subscribe(function (data) {
            if (_this.responseCount == 0) {
                _this.responseTime = 0;
            }
            _this.responseTime = data[_this.responseCount - 1] / 1000;
        });
    };
    ResponseComponent.prototype.clear = function () {
        this.messages = null;
        this.subscription2.unsubscribe();
    };
    ResponseComponent.prototype.connect = function () {
        this.responseService.connect().subscribe();
    };
    ResponseComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-response',
            template: __webpack_require__(/*! ./response.component.html */ "./src/app/response/response.component.html"),
            styles: [__webpack_require__(/*! ./response.component.css */ "./src/app/response/response.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_response_service__WEBPACK_IMPORTED_MODULE_2__["ResponseService"], _services_user_service_service__WEBPACK_IMPORTED_MODULE_6__["UserService"]])
    ], ResponseComponent);
    return ResponseComponent;
}());



/***/ }),

/***/ "./src/app/response/response.service.ts":
/*!**********************************************!*\
  !*** ./src/app/response/response.service.ts ***!
  \**********************************************/
/*! exports provided: ResponseService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResponseService", function() { return ResponseService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");




var ResponseService = /** @class */ (function () {
    function ResponseService(http) {
        this.http = http;
        var source = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["interval"])(1000);
    }
    ResponseService.prototype.getReponseCount = function () {
        return this.http.get('/ResponseCount');
    };
    ResponseService.prototype.getReponseTime = function () {
        return this.http.get('/ResponseTime');
    };
    ResponseService.prototype.order = function () {
        return this.http.get('/startOrder');
    };
    ResponseService.prototype.getLastHundredResponses = function () {
        return this.http.get('/ResponseData');
    };
    ResponseService.prototype.connect = function () {
        return this.http.get('/connect');
    };
    ResponseService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], ResponseService);
    return ResponseService;
}());



/***/ }),

/***/ "./src/app/user-form/user-form.component.css":
/*!***************************************************!*\
  !*** ./src/app/user-form/user-form.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "form{\r\n    padding-top: 0px;\r\n   \r\n    \r\n}\r\n.card bg-dark my-5{\r\n    padding: 0px;\r\n    \r\n}\r\n.card-body{\r\n    padding-top: 0px;\r\n   \r\n}\r\ninput[type=checkbox] {\r\n  -webkit-transform: scale(1.5);\r\n          transform: scale(1.5);\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC91c2VyLWZvcm0vdXNlci1mb3JtLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxnQkFBZ0I7OztBQUdwQjtBQUNBO0lBQ0ksWUFBWTs7QUFFaEI7QUFBQztJQUNHLGdCQUFnQjs7QUFFcEI7QUFDQTtFQUNFLDZCQUFxQjtVQUFyQixxQkFBcUI7QUFDdkIiLCJmaWxlIjoiYXBwL3VzZXItZm9ybS91c2VyLWZvcm0uY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbImZvcm17XHJcbiAgICBwYWRkaW5nLXRvcDogMHB4O1xyXG4gICBcclxuICAgIFxyXG59XHJcbi5jYXJkIGJnLWRhcmsgbXktNXtcclxuICAgIHBhZGRpbmc6IDBweDtcclxuICAgIFxyXG59LmNhcmQtYm9keXtcclxuICAgIHBhZGRpbmctdG9wOiAwcHg7XHJcbiAgIFxyXG59XHJcbmlucHV0W3R5cGU9Y2hlY2tib3hdIHtcclxuICB0cmFuc2Zvcm06IHNjYWxlKDEuNSk7XHJcbn1cclxuIl19 */"

/***/ }),

/***/ "./src/app/user-form/user-form.component.html":
/*!****************************************************!*\
  !*** ./src/app/user-form/user-form.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<div class=\"container\">\n  <div class=\"row\">\n    <div class=\"col-sm-6\">\n      <input #fileInput type=\"file\" ng2FileSelect [uploader]=\"uploader\"/>\n    </div>\n    <div class=\"col-sm-6\">\n      <div class=\"statistic-block block\"  [style.height]=\"'60px'\" [style.margin]=\" '0px' \">\n      <form>\n        <input type=\"number\" [style.width]=\"'60px'\" [style.background-color]=\"'blue'\" [(ngModel)]=\"ordersPerTimeSlice && ordersPerTimeSlice.orderPerSlice\"  id=\"orderPerSlice\"  name =\"orderPerSlice\" (change)=\"onSubmitOrdersPerTimeSlice()\"\n               #orderPerSlice=\"ngModel\" >\n        :\n        <input type=\"number\" [style.width]=\"'40px'\" [style.background-color]=\"'blue'\" [(ngModel)]=\"ordersPerTimeSlice && ordersPerTimeSlice.timePeriod\"  id=\"timePeriod\"  name =\"timePeriod\" (change)=\"onSubmitOrdersPerTimeSlice()\"\n               #timePeriod=\"ngModel\" > &nbsp;\n        <!--GWClient<input type=\"checkbox\" [style.heigt]=\"'60px'\"[(ngModel)]=\"ordersPerTimeSlice && ordersPerTimeSlice.GWClient\"  name =\"GWClient\" (change)=\"onSubmitOrdersPerTimeSlice()\"  #GWClient=\"ngModel\">-->\n      </form>\n      </div>\n    </div>\n  </div>\n</div>\n <div class=\"card my-5\">\n  <div class=\"card-body\">\n\n    <form (ngSubmit)=\"onSubmit()\" #userForm=\"ngForm\">\n      <div class=\"form-group\">\n        <label for=\"ip\">IP</label>\n        <input type=\"text\" [(ngModel)]=\"user && user.ip\" class=\"form-control\" id=\"ip\"  name =\"ip\" (change)=\"onSubmit()\"\n           #ip=\"ngModel\">\n      </div>\n      \n      <div class=\"form-group\">\n        <label for=\"port\">Port Number</label>\n        <input type=\"number\" [(ngModel)]=\"user && user.port\" class=\"form-control\" id=\"port\" value=8181 name=\"port\" placeholder=\"192.168.0.50\"\n          required (change)=\"onSubmit()\" #port=\"ngModel\">\n     </div>\n      <div class=\"form-group\">\n        <label for=\"endpoint\">No of endpoints</label>\n        <input type=\"number\" [(ngModel)]=\"user && user.endpoint\" class=\"form-control\" id=\"endpoint\" name=\"endpoint\" placeholder=\"No of endpoints\" value=1 (change)=\"onSubmit()\"\n           #endpoint=\"ngModel\">\n       </div>\n      <div class=\"form-group\">\n        <label for=\"noOfOrders\">No of Orders</label>\n        <input type=\"number\" [(ngModel)]=\"user && user.noOfOrders\" class=\"form-control\" id=\"noOfOrders\" name=\"noOfOrders\" placeholder=\"No of Orders\"\n          required (change)=\"onSubmit()\" #noOfOrders=\"ngModel\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"orderQty\">OrderQuantity</label>\n        <input type=\"number\" [(ngModel)]=\"user && user.orderQty\" class=\"form-control\" id=\"orderQty\" name=\"orderQty\" placeholder=\"OrderParam Quantity\"\n          required (change)=\"onSubmit()\" #noOfOrders=\"ngModel\">\n      </div>\n    \n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/user-form/user-form.component.ts":
/*!**************************************************!*\
  !*** ./src/app/user-form/user-form.component.ts ***!
  \**************************************************/
/*! exports provided: UserFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserFormComponent", function() { return UserFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_user_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../_services/user-service.service */ "./src/app/_services/user-service.service.ts");
/* harmony import */ var _model_user__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../_model/user */ "./src/app/_model/user.ts");
/* harmony import */ var _response_response_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../response/response.service */ "./src/app/response/response.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var _model_OrdersPerTimeSlice__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../_model/OrdersPerTimeSlice */ "./src/app/_model/OrdersPerTimeSlice.ts");
/* harmony import */ var _services_ordersper_time_slice_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../_services/ordersper-time-slice.service */ "./src/app/_services/ordersper-time-slice.service.ts");










var UserFormComponent = /** @class */ (function () {
    function UserFormComponent(route, router, userService, responseService, ordersPerTimeSliceService, http) {
        var _this = this;
        this.route = route;
        this.router = router;
        this.userService = userService;
        this.responseService = responseService;
        this.ordersPerTimeSliceService = ordersPerTimeSliceService;
        this.http = http;
        this.onSubmit = function () {
            var _this = this;
            this.userService.save(this.user).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.onSubmitOrdersPerTimeSlice = function () {
            var _this = this;
            console.log(this.ordersPerTimeSlice.GWClient);
            this.ordersPerTimeSliceService.save(this.ordersPerTimeSlice).subscribe(function (result) { return _this.gotoUserList(); });
        };
        this.user = new _model_user__WEBPACK_IMPORTED_MODULE_4__["User"]();
        this.ordersPerTimeSlice = new _model_OrdersPerTimeSlice__WEBPACK_IMPORTED_MODULE_8__["OrdersPerTimeSlice"]();
        // this.user.ip = "192.168.0.50";
        // this.user.port = 8181;
        // this.user.endpoint = 10;
        // this.user.noOfOrders = 100;
        // this.user.orderQty = 1;
        this.userService.findAll().subscribe(function (data) {
            _this.users = data;
            _this.user.noOfOrders = _this.users[_this.users.length - 1].noOfOrders;
            _this.user.ip = _this.users[_this.users.length - 1].ip;
            _this.user.port = _this.users[_this.users.length - 1].port;
            _this.user.endpoint = _this.users[_this.users.length - 1].endpoint;
            _this.user.orderQty = _this.users[_this.users.length - 1].orderQty;
            _this.ordersPerTimeSlice.timePeriod = 1;
            _this.ordersPerTimeSlice.orderPerSlice = 700;
        });
    }
    UserFormComponent.prototype.ngOnInit = function () {
        var headers = [{ name: 'Accept', value: 'application/json' }];
        this.uploader = new ng2_file_upload__WEBPACK_IMPORTED_MODULE_7__["FileUploader"]({ url: '/api/files', autoUpload: true, headers: headers });
        this.uploader.onCompleteAll = function () { return alert('File uploaded'); };
    };
    UserFormComponent.prototype.gotoUserList = function () {
        this.router.navigate(['/users']);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('fileInput'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], UserFormComponent.prototype, "fileInput", void 0);
    UserFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-user-form',
            template: __webpack_require__(/*! ./user-form.component.html */ "./src/app/user-form/user-form.component.html"),
            styles: [__webpack_require__(/*! ./user-form.component.css */ "./src/app/user-form/user-form.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _services_user_service_service__WEBPACK_IMPORTED_MODULE_3__["UserService"],
            _response_response_service__WEBPACK_IMPORTED_MODULE_5__["ResponseService"], _services_ordersper_time_slice_service__WEBPACK_IMPORTED_MODULE_9__["OrdersperTimeSliceService"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClient"]])
    ], UserFormComponent);
    return UserFormComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\kaveeshad\Documents\springbootAngular\ang-app\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map