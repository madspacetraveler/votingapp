<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rozpoczęcie głosowania</title>
    <jsp:include page="../include/resurces.jsp"/>
</head>
<body>
<jsp:include page="../include/menu.jsp" />
<div class="container justify-content-xl-center">
<h4>Wybierz budynek dla którego chcesz przeprowadzić głosowanie:</h4>
    <input type="text" id="myInput" onkeyup="filterByColumn(1)" placeholder="Filtruj po adresie" class="form-control text-center">
    <table id="myTable" class="table table-hover">
        <tr class="header bg-dark text-white">
            <th scope="col-sm-1">ID</th>
            <th scope="col-sm-6">Adres:</th>
            <th scope="col-sm-2">Mieszkań:</th>
            <th scope="col-sm-2">Powierzchnia:</th>
        </tr>
        <c:forEach items="${buildings}" var="building">
            <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
                <td><a href="${pageContext.servletContext.contextPath}/voteForm/${building.id}" class="text-dark">${building.id}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/voteForm/${building.id}" class="text-dark">${building.adres}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/voteForm/${building.id}" class="text-dark">${flats.countFlatsInBuilding(building.id)}</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/voteForm/${building.id}" class="text-dark">${flats.allFlatsInBuildingArea(building.id)}</a></td>
            </tr>
        </c:forEach>
        <tr class="row-striped border-left border-right border-bottom bg-dark text-white">
            <td colspan="4" class="text-center">Ilość budynków w bazie: ${countBuildings}</td>
        </tr>
    </table>
</div>
<jsp:include page="../include/footer.jsp" />
</body>
</html>
