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
            <td class="text-dark">Numer uchwały: ${voting.resolution}</td>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">Tytuł uchwały: ${voting.title}</td>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Głosowało za: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${voting.votesFor}"/>
            </td>
        </tr>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Głosowało przeciw: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${voting.votesAgainst}"/>
            </td>
        </tr>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">
                Wstrzymało się od głosu: <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${voting.votesAbstain}"/>
            </td>
        </tr>
<c:if test="${voting.result == true}">
        <tr scope="row" class="row-striped border-left border-right border-bottom">
            <td class="text-success">
                Uchwała została uchwalona
            </td>
        </tr>
</c:if>
<c:if test="${voting.result == false}">
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
    <td class="text-dark">${voting.content}</td>
    </tr>
        <c:if test="${voting.result == true}">
            <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
                <td class="text-dark"><a href="${pageContext.servletContext.contextPath}/votings/generatepdf/${voting.id}">Utwórz dokument PDF</a></td>
            </tr>
        </c:if>
    </table>
</div>

</body>
<jsp:include page="../include/footer.jsp" />
</body>
</html>