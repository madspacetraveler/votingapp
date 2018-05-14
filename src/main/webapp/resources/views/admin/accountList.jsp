<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel administracyjny</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<div class="container justify-content-md-center text-center border border-danger bg-admin">
    <h3>Panel administracyjny</h3>
    <jsp:include page="include/adminMenu.jsp" />
    <input type="text" id="myInput" onkeyup="filterByColumn(1)" placeholder="Filtruj po nazwie użytkownika" class="form-control text-center">
    <table id="myTable" class="table table-hover table-sm">
        <tr class="header bg-warning text-dark border-left border-right border-top">
            <th scope="col-sm-1">ID</th>
            <th scope="col-sm-5">Username:</th>
            <th scope="col-sm-2">Ranga:</th>
            <th scope="col-sm-2">Email:</th>
            <th scope="col-sm-1">Aktywny:</th>
            <th scope="col-sm-1">Opcje:</th>
        </tr>
    <c:forEach items="${accounts}" var="account">
        <tr scope="row" class="row-striped-admin border-left border-right border-bottom text-dark">
            <td><a href="${pageContext.servletContext.contextPath}/admin/account/${account.id}" class="text-dark">${account.id}</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/admin/account/${account.id}" class="text-dark">${account.username}</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/admin/account/${account.id}" class="text-dark">${account.role}</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/admin/account/${account.id}" class="text-dark">${account.email}</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/admin/account/${account.id}" class="text-dark">${account.active}</a></td>
            <td>
                <a href="/admin/account/delete?accountId=${account.id}" class="text-dark btn btn-sm btn-danger">Usuń</a>
            </td>
        </tr>
    </c:forEach>
        <tr class="row-striped-admin border-left border-right border-bottom bg-warning text-dark">
            <td colspan="6" class="text-center">Ilość kont w bazie: ${countAccounts}</td>
        </tr>
    </table>
</div>

</body>
</html>
