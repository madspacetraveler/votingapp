<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 15.03.2018
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Głosowania</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="menu.jsp" />
    <div class="container justify-content-xl-center">
        <div class="row ">
            <div class="col">
                <h4>Lista głosowań:</h4>
            </div>
        </div>
        <div class="row bg-dark text-white">
            <div class="col-sm-1">ID: </div>
            <div class="col-sm-3">Adres:</div>
            <div class="col-sm-2">Data:</div>
            <div class="col-sm-5">Tytuł:</div>
            <div class="col-sm-1">Wynik:</div>
            <div class="w-100"></div>
        </div>
        <c:forEach items="${votings}" var="voting">
            <div class="row row-striped border-left border-right">
                <div class="col-sm-1">${voting.id}</div>
                <div class="col-sm-3">${voting.building.adres}</div>
                <div class="col-sm-2">${voting.date}</div>
                <div class="col-sm-5">${voting.title}</div>
                <div class="col-sm-1">${voting.result}</div>
                <div class="w-100 border-bottom"></div>
            </div>
        </c:forEach>
    </div>
<jsp:include page="footer.jsp" />
</body>
</html>
