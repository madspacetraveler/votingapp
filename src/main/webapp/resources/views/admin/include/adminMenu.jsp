<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="w-100"></div>
<div class="row justify-content-xl-center">
    <div class="btn-group btn-group-lg mb-3 justify-content-xl-center">
        <a href="${pageContext.servletContext.contextPath}/admin" class="btn btn-secondary">Strona główna panelu</a>
        <div class="btn-group btn-group-lg">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">
                Konta<span class="caret"></span></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/accountList">Lista kont</a>
                <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/account">Dodaj konto</a>
            </div>
        </div>
        <div class="btn-group btn-group-lg">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">
                Osoby<span class="caret"></span></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/personList">Lista osób</a>
                <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/person">Dodaj osobę</a>
            </div>
        </div>
        <a href="${pageContext.servletContext.contextPath}/" class="btn btn-info">Wyjdź z panelu</a>
    </div>
</div>