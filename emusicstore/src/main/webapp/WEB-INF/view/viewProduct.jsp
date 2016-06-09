<%@include file="/WEB-INF/view/template/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Product Details</h2>
            <p class="lead">Here is the details of the product you chose</p>
        </div>
        <div class="container" ng-app="cartApp">
            <div class="col-md-5">
                <img
                        src="<c:url value="/resources/images/${product.productId}.png"/> "
                        alt="image"
                        style="width: 100%; height:300px">
            </div>
            <div class="col-md-5">
                <h3>${product.productName}</h3>
                <p>${product.productDescription}</p>
                <p><strong>MANUFACTURER:</strong>${product.productManufacturer}</p>
                <p><strong>CATEGORY:</strong>${product.productCategory}</p>
                <p><strong>CONDITION:</strong>${product.productCondition}</p>
                <p><strong>PRICE:</strong>${product.productPrice}</p>
                <br>
                <c:set var="role" scope="page" value="${param.role}" />
                <c:set var="url" scope="page" value="/product/productList" />
                <c:if test="${role='admin'}">
                    <c:set var="url" value="/admin/productinventory" />
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}" />" class="btn btn-primary">BACK</a>
                    <a href="#" class="btn btn-warning btn-large"
                       ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span>ORDER NOW</a>
                    <a href="<spring:url value="/customer/cart" />"
                    class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>VIEW CART </a>
                </p>
            </div>
        </div>

<%@include file="template/footer.jsp" %>