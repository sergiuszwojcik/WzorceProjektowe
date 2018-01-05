<%--spring tags to render html <endblock></endblock>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<style>

    i {
        position: absolute;
        transform: translate(40%, 10%);
    }

</style>
<div>
    <br>
    <br>
</div>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administration page</h1>
            <p class="lead">Administrator panel</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">

            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a
                    href="<c:url value="/j_spring_security_check"></c:url>">Logout</a>
            </h2>

        </c:if>

        <h3>
            <a href="<c:url value="/admin/productChange"></c:url> ">Product item panel</a>
        </h3>

        <p>VIEW/CHECK/MODIFY products</p>

    </div>


</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
