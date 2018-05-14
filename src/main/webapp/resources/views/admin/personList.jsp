<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <input type="text" id="myInput" onkeyup="filterByColumn(1)" placeholder="Filtruj po imieniu lub nazwisku" class="form-control text-center">
    <table id="myTable" class="table table-hover table-sm">
        <tr class="header bg-warning text-dark border-left border-right border-top">
            <th scope="col-sm-1">ID</th>
            <th scope="col-sm-6">Imię i nazwisko:</th>
            <th scope="col-sm-1">Opcje:</th>
        </tr>
    <c:forEach items="${persons}" var="person">
        <tr scope="row" class="row-striped-admin border-left border-right border-bottom text-dark">
            <td>${person.id}</td>
            <td>${person.name} ${person.surname}</td>
            <td><a href="/admin/person/delete?personId=${person.id}" class="text-dark btn btn-sm btn-danger">Usuń</a></td>
        </tr>
    </c:forEach>
        <tr class="row-striped-admin border-left border-right border-bottom bg-warning text-dark">
            <td colspan="4" class="text-center">Ilość osób w bazie: ${countPersons}</td>
        </tr>
    </table>
</div>
</body>
</html>
