<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Głosowania</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
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
        <a href="../votings">Zobacz listę głosowań</a>
    </div>
    </center>
<jsp:include page="include/footer.jsp" />
</body>
</html>
