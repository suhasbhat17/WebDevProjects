<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Product Inventory</h2>
            <p class="lead">Hello Admin..! Here you go. All the products in the inventory</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Product Category</th>
                <th>Product Description</th>
                <th>Product Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img
                            src="<c:url value="/resources/images/${product.productId}.png"/> "
                            alt="image"
                            style="width: 100%"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice}</td>
                    <td>
                        <a href="<spring:url value="/product/viewproduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-eye-open"></span></a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/product/editproduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-pencil"></span></a>

                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/addproduct"/>" class="btn btn-primary">ADD PRODUCT </a>


<%@include file="template/footer.jsp" %>