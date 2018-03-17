<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 16.03.2018
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>building page</title>
<%--    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col">
            <h2>Lista budynków: </h2>
        </div>

    </div>
        <c:forEach items="${buildings}" var="building">








            <div class="row">
                <div class="col">ID: </div>
                <div class="col">${building.id}</div>
            </div>
        <div class="w-100"></div>
            <div class="row">
                <div class="col">Adres: </div>
                <div class="col">${building.adres}</div>
            </div>
        <div class="w-100"></div>
            <div class="row">
                <div class="col">Powierzchnia: </div>
                <div class="col">${building.area}</div>
            </div>
        <div class="w-100"></div>
            <div class="row">
                <div class="col">Ilość mieszkań: </div>
                <div class="col">${building.flatCount}</div>
            </div>
        <div class="w-100"></div>


        </c:forEach>

</div>



</body>
</html>
