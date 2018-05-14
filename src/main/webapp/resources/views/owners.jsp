<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista właścicieli</title>
    <jsp:include page="include/resurces.jsp"/></head>
<body>
<jsp:include page="include/menu.jsp" />
<div class="container justify-content-xl-center">
    <input type="text" id="myInput" onkeyup="filterByColumn(1)" placeholder="Filtruj po nazwisku" class="form-control text-center">
    <table id="myTable" class="table table-hover">
        <tr class="header bg-dark text-white">
            <th scope="col-sm-1">ID</th>
            <th scope="col-sm-5">Imie i Nazwisko</th>
            <th scope="col-sm-4"></th>
            <th scope="col-sm-2">Mieszkań</th>
        </tr>
        <c:forEach items="${owners}" var="owner">
            <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
                <td><a href="${pageContext.servletContext.contextPath}/owners/${owner.id}" class="text-dark">${owner.id}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/owners/${owner.id}" class="text-dark">${owner.name} ${owner.surname}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/owners/${owner.id}" class="text-dark">${"-"}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/owners/${owner.id}" class="text-dark">${"-"}</a></td>
            </tr>
        </c:forEach>
        <tr class="row-striped border-left border-right border-bottom bg-dark text-white">
            <td colspan="4" class="text-center">Ilość ludzi w bazie: ${countOwners}</td>
        </tr>
    </table>
</div>
<jsp:include page="include/footer.jsp" />
</body>
</html>
