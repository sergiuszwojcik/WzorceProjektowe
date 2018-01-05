<%--spring tags to render html <endblock></endblock>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<div>
    <br>
    <br>
</div>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product detail</h1>
            <p class="lead">All information about the product.</p>
        </div>

    </div>

</div>
<style>

    hr.style14 {
        border: 0;
        height: 1px;
        background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
        background-image: -moz-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
        background-image: -ms-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
        background-image: -o-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
    }

</style>

<hr class="style14">

<div class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resources/images/${product.productId}.png"></c:url> " alt="image"
                 style="width: 100%">
        </div>
        <div class="col-md-5">
            <h3>${product.productName}</h3>
            <p>${product.productDescription}</p>
            <p><strong>Manufacturer</strong> : ${product.productManufacturer}</p>
            <p><strong>Category</strong> : ${product.category}</p>
            <p><strong>Condition</strong> : ${product.productCondition}</p>
            <h4>${product.productPrice} PLN</h4>

            <br>
            <%--Using JSTL set function to define variable --%>
            <c:set var="role" scope="page" value="${param.role}"></c:set>
            <c:set var="url" scope="page" value="/productList"></c:set>
            <c:if test="${role='admin'}">

                <c:set var="url" scope="page" value="/admin/productChange"></c:set>

            </c:if>

            <p ng-controller="cartCtrl">
                <a href="<c:url value="${url}"></c:url> " ><button type="button" class="btn btn-default">Back</button></a>
                <a href="#" class="btn btn-warning btn-large"
                   ng-click="addToCart('${product.productId}')">
                    <i class="fa fa-cart-plus" aria-hidden="true"></i>Order Now</a>
                <a href="<spring:url value="/cart" ></spring:url> " >
                    <button type="button" class="btn btn-default"><i class="fa fa-hand-o-right" aria-hidden="true">
                    </i>View Cart</button></a>
            </p>


        </div>
    </div>


</div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>


<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
