<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://struts.apache.org/tags-bean" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj osobę</title>
    <jsp:include page="include/resurces.jsp" />
</head>
<body>
<div class="container justify-content-sm-center">
    <jsp:include page="include/adminMenu.jsp" />
    <div class="row justify-content-sm-center">
       <div class="w-100"></div>

    <form:form action="person/add" modelAttribute="persons" method="post" class="col-sm-5">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Imię</span>
            </div>
            <form:input path="name" type="text" class="form-control" placeholder="Imię" aria-label="Imię" aria-describedby="basic-addon1"/><br>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon2">Nazwisko</span>
            </div>
            <form:input path="surname" type="text" class="form-control" placeholder="Nazwisko" aria-label="Nazwisko" aria-describedby="basic-addon1"/><br>
        </div>
        <div class="w-100"></div>
        <div class="row justify-content-xl-center col-sm-12 mb-3 center-block">
            <input type="submit" name="add" value="Dodaj" class="btn btn-success btn-lg m-3">
            <a href="${pageContext.servletContext.contextPath}/admin" class="btn btn-danger btn-lg m-3">Anuluj</a>
        </div>
    </form:form>
    </div>
</div>
</body>
</html>
