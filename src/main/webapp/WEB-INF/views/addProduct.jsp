<%--spring tags to render html <endblock></endblock>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<style>
    span.tab {
        padding: 0 15px; /* Or desired space*/
    }

    span.left {

        margin-left: 55px;

    }
</style>
<div>
    <br>
    <br>
</div>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the information about product:</p>
        </div>


        <form:form action="${pageContext.request.contextPath}/admin/productChange/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
            <%--enctype="multipard/form-data usef for uploading files--%>
            <div class="form-gorup">

                <label for="name">Name</label><form:errors path="productName" cssStyle="color:red"></form:errors>
                <form:input path="productName" id="name" class="form-Control"></form:input>
            </div>
            <br>
            <div class="form-group">
                <label for="category">Category</label> <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                                 value="Game"></form:radiobutton>Game</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                                 value="Accesory"></form:radiobutton>Accesory</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                                 value="Hardware"></form:radiobutton>Hardware</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                                 value="Books"></form:radiobutton>Books</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                                 value="Education"></form:radiobutton>Education</label>
                <span class="tab"></span>
            </div>

            <div class="form-group">

                <label for="description">Description</label>
                <form:textarea rows="3" path="productDescription" id="description" class="form-Control"></form:textarea>

            </div>

            <div class="form-group">

                <label for="price">Price</label><form:errors path="productPrice" cssStyle="color:red"></form:errors>
                <form:input path="productPrice" id="price" class="form-Control"></form:input>

            </div>

            <div class="form-group">
                <label for="category">Condition</label> <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="category"
                                                                 value="New"></form:radiobutton>New</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="category"
                                                                 value="Used"></form:radiobutton>Used</label>
                <span class="tab"></span>
            </div>

            <div class="form-group">
                <label for="category">Status </label> <span class="left"></span>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="category"
                                                                 value="Active"></form:radiobutton>Active</label>
                <span class="tab"></span>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="category"
                                                                 value="Inactive"></form:radiobutton>Inactive</label>
                <span class="tab"></span>
            </div>


            <div class="form-group">

                <label for="manufacturer">Manufacturer</label>
                <form:input path="productManufacturer" id="manufacturer" class="form-Control"></form:input>

            </div>

            <div class="form-group">
                <label class="control-label" for="productImage">Upload Picture</label>
                <form:input id="productImage" path="productImage" type="file" class="form:input-large"
                            value="Upload"></form:input>
            </div>

            <div class="form-group">

                <label for="description">Units In Stock</label><form:errors path="unitsInStock"
                                                                            cssStyle="color:red"></form:errors>
                <form:input path="unitsInStock" id="unitInStock" class="form-Control"></form:input>

            </div>


            <br><br>

            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<c:url value="/admin/productChange"></c:url>">
                <button type="button" class="btn btn-default">Cancel</button>
            </a>

        </form:form>
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


<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp" %>
