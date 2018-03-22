<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<center>
    <h2>Wynik głosowania - podsumowanie</h2>
    <h3>Numer uchwały: ${votingAdded.resolution}</h3>
    <h3>Tytuł uchwały: ${votingAdded.title}</h3>

    <b>Głosowało za: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesFor}" /></b><br>
    <b>Głosowało przeciw: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesAgainst}" /></b><br>
    <b>Wstrzymało się od głosu: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesAbstain}" /></b><br>
    <c:if test="${votingAdded.result == true}">Uchwała została uchwalona</c:if><br>
    <c:if test="${votingAdded.result == false}">Uchwała została odrzucona</c:if><br>
    <h3>Treść uchwały</h3>
    <p>${votingAdded.content}</p>
        <div class="w-100 mb-3"></div>
        <h3 class="text-success">Głosowanie zostało dodane do bazy</h3>
        <div class="w-100 mb-3"></div>
        <a href="votings">Zobacz listę głosowań</a>
    </div>
    </center>
<jsp:include page="footer.jsp" />
</body>
</html>
