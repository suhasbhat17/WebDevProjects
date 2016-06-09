<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: suhas
  Date: 5/2/2016
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>MY E-MUSIC STORE</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Main CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">MY E-MUSIC STORE</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/">HOME</a></li>
                        <li><a href="${pageContext.request.contextPath}/product/productList">PRODUCTS</a></li>
                        <li><a href="#contact">CONTACT</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>WELCOME: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">logout</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li><a href="<c:url value="/customer/cart" />">CART</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin" />">ADMIN</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
                            <li><a href="${pageContext.request.contextPath}/register">REGISTER</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>
