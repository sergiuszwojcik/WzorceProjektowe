<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zerg
  Date: 2018-01-04
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <br>
    <br>
</div>


<div class="container-wrapper">

    <div class="container">

        <section>

            <div class="jumbotron">

                <div class="container">

                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>

                </div>

            </div>

        </section>
        <%--Acces to the cartApp js module controller.js--%>
        <section class="container" ng-app="cartApp">

            <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <br>
                <%--<div>--%>
                    <%--<a class="btn btn-danger pull-left" ng-click="clearCart()">--%>
                        <%--<i class="fa fa-times-circle-o" aria-hidden="true"></i>Clear Cart</a>--%>
                <%--</div>--%>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat="item in cart.cartItems">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td>
                            <a class="badge badge-danger" href="#" ng-click="removeFromCart(item.product.productId)">
                            <i class="fa fa-times" aria-hidden="true" style="color: white">
                            </i><font color="white"> Remove</font></a>
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{cart.grandTotal}}</th>
                        <th></th>
                    </tr>

                </table>
                <br>
                <a href="<spring:url value="/productList"></spring:url>" class="btn btn-primary pull-right">Continue Shopping</a>
                <a class="btn btn-danger pull-left" ng-click="clearCart()">
                    <i class="fa fa-times-circle-o" aria-hidden="true" style="color: white">
                    </i><font color="white"> Clear Cart</font></a>
            </div>

        </section>

    </div>

</div>
<br>
<br>
<br>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
