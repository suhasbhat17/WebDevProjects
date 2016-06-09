<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Administrator Page</h2>
            <p class="lead">Welcome Admin..!! Please modify the inventory as per your requirement.</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>
            Welcome ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/>">LOGOUT</a>
        </h3>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>"> Product Inventory </a>
        </h3>
        <p>Here you can check and modify the inventory as per you need.</p>





<%@include file="template/footer.jsp"%>