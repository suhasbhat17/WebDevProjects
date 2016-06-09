<%@include file="/WEB-INF/view/template/header.jsp"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-wrapper">

        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Registered Successfully</h1>

                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/product/productList" />" class="btn btn-default">Products</a>
            </p>

        </section>
    </div>
</div>



<%@include file="/WEB-INF/view/template/footer.jsp"%>