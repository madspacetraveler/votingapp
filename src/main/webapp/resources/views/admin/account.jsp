<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://struts.apache.org/tags-bean" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj konto</title>
    <jsp:include page="include/resurces.jsp" />
</head>
<body>
<div class="container justify-content-sm-center">
    <jsp:include page="include/adminMenu.jsp" />
    <div class="row justify-content-sm-center">
       <div class="w-100"></div>

    <form:form action="account/add" modelAttribute="accounts" method="post" class="col-sm-5">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Nazwa użytkownika</span>
            </div>
            <form:input path="username" type="text" class="form-control" placeholder="Nazwa użytkownika" aria-label="Nazwa użytkownika" aria-describedby="basic-addon1"/><br>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon2">Adres email</span>
            </div>
            <form:input path="email" type="text" class="form-control" placeholder="Adres email" aria-label="Adres email" aria-describedby="basic-addon2"/><br>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">Hasło</span>
            </div>
            <form:input path="password" type="password" class="form-control" placeholder="Hasło" aria-label="Hasło" aria-describedby="basic-addon3"/><br>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon5">Ranga:</span>
            </div>
            <form:input path="role" type="text" class="form-control" placeholder="Ranga" aria-label="Ranga" aria-describedby="basic-addon5"/><br>
        </div>
        <div class="form-check">
            <form:checkbox path="active" class="form-check-input" id="exampleCheck1"></form:checkbox>
            <label class="form-check-label" for="exampleCheck1">Aktywny?</label>
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
