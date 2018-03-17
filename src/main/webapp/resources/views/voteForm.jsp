<%--
  Created by IntelliJ IDEA.
  User: cinus
  Date: 18-03-17
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>VotingApp</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container">
    <div class="row justify-content-xl-center">

        <h3>Dane budynku: </h3>
        <div class="w-100"></div>
        ID: ${building.id}
        <div class="w-100"></div>
        Adres: ${building.adres}
        <div class="w-100"></div>
    </div>
    <div class="row justify-content-xl-center">
        <h4>Lista mieszkań:</h4>
        <div class="w-100"></div>
        <div class="row">
            <div class="col-sm">ID: </div>
            <div class="col-sm">Numer: </div>
            <div class="col-sm">Powierzchnia: </div>
            <div class="col-sm">Właściciel:</div>
            <div class="w-100"></div>
        </div>
        <c:forEach items="${flats}" var="flats">
            <div class="row">
                <div class="col-sm">${flats.id}</div>
                <div class="col-sm">${flats.flatNumber}</div>
                <div class="col-sm">${flats.area}</div>
                <div class="col-sm">${flats.authorizedVoter}</div>
                <div class="w-100"></div>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>
