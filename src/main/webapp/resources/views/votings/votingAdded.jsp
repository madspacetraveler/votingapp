<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Głosowania</title>
    <jsp:include page="../include/resurces.jsp"/>
</head>
<body>
<jsp:include page="../include/menu.jsp" />

<div class="container justify-content-xl-center">
    <table id="myTable" class="table">
        <tr class="header bg-dark text-white">
            <th scope="col-sm-1" class="text-center">Wynik głosowania - podsumowanie</th>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">Numer uchwały: ${votingAdded.resolution}</td>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">Tytuł uchwały: ${votingAdded.title}</td>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Głosowało za: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesFor}"/>
            </td>
        </tr>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Głosowało przeciw: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesAgainst}"/>
            </td>
        </tr>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Wstrzymało się od głosu: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${votingAdded.votesAbstain}"/>
            </td>
        </tr>
<c:if test="${votingAdded.result == true}">
        <tr scope="row" class="row-striped border-left border-right border-bottom">
            <td class="text-success">
                Uchwała została uchwalona
            </td>
        </tr>
</c:if>
<c:if test="${votingAdded.result == false}">
    <tr scope="row" class="row-striped border-left border-right border-bottom">
    <td class="text-danger">
    Uchwała została odrzucona
    </td>
    </tr>
</c:if>
    <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
    <td class="text-dark">Treść uchwały:</td>
    </tr>
    </tr>
    <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
    <td class="text-dark">${votingAdded.content}</td>
    </tr>
<c:if test="${voting.result == true}">
    <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
        <td class="text-dark">
            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/votings/generatepdf/${votingAdded.id}">Utwórz dokument PDF</a>
            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/sendEmail">Wyślij na maila</a>
        </td>
    </tr>
</c:if>
    <tr class="row-striped border-left border-right border-bottom bg-success text-white">
        <td class="text-center">Głosowanie zostało dodane do bazy</td>
    </tr>
    <tr class="row-striped border-left border-right border-bottom bg-dark text-white">
    <td class="text-center"><a class="info-link" href="../votings">Zobacz listę głosowań</a></td>
    </tr>
    </table>
</div>
</body>
<jsp:include page="../include/footer.jsp" />
</body>
</html>