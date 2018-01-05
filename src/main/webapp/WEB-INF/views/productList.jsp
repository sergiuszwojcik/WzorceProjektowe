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
            <h1>All products</h1>
            <p class="lead">Checkout all the products available now!</p>
        </div>

        <table class="table table-bordered table-hover">

            <thead class="thead-dark">
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>

            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>
                        <img src="<c:url value="/resources/images/${product.productId}.png"></c:url> " alt="image"
                             style="width: 100%">
                    </td>
                    <td>${product.productName}</td>
                    <td>${product.category}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}PLN</td>
                    <!-- For making dynamic url link send (Dynamic parameter spring generates url -->
                    <td><a href="<spring:url value="/productList/productDetail/${product.productId}"></spring:url> ">
                        <i class="fa fa-info-circle" aria-hidden="true"></i></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
