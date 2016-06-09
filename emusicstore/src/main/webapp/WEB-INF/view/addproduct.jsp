<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Add A New Product</h2>
            <p class="lead">Here is the details of the product you chose</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/admin/product/addproduct"
                   method="post" commandName="product" enctype="multipart/form-data">

        <div class="form-group">
            <label for="name">Name</label> <form:errors path="productName" cssStyle="color: red" />
            <form:input path="productName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="string"/>Strings</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="wind"/>Wind</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessories"/>Accessories</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label> <form:errors path="productPrice" cssStyle="color: red" />
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new"/>New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used"/>Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="inactive"/>Inactive</label>
        </div>
        <div class="form-group">
            <label for="units">Unit in Stock</label><form:errors path="unitInStock" cssStyle="color: red" />
            <form:input path="unitInStock" id="units" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="productImage">Upload Picture</label>
            <form:input path="productImage" id="productImage" type="file" class="form-Control"/>
        </div>
        <br><br>

        <input type="submit" value="SUBMIT" class="btn btn-primary">
        <a href="<c:url value="/admin/productinventory"/>" class="btn btn-default">CANCEL</a>


        </form:form>

<%@include file="template/footer.jsp" %>