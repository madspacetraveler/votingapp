<%--
  Created by IntelliJ IDEA.
  User: cinus
  Date: 18-03-17
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>VotingApp</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container justify-content-xl-center">
    <div class="row ">
        <h4>Dane budynku: </h4>
        <div class="w-100"></div>
        ID: ${building.id}
        <div class="w-100"></div>
        Adres: ${building.adres}
        <div class="w-100"></div>
    </div>

<%--    <form:form action="addVote" modelAttribute="voting" method="post">
        <form:label path="resolution">Numer uchwaly:</form:label>
        <form:input path="resolution"/>
        <form:label path="title">Tytul uchwaly:</form:label>
        <form:input path="title"/>
        <form:label path="content">Tresc uchwaly</form:label>
        <form:input path="content"/>
        <form:label path="moderator">Moderator: </form:label>
        <form:input path="moderator"/>
        <form:label path="secretary">Sekretarz: </form:label>
        <form:input path="secretary"/>
        <input type="submit" name="apply" value="Zatwierdz"/>
    </form:form>--%>
    <div class="row justify-content-xl-center">
        <div class="col">
            <h2>Lista mieszkań: </h2>
        </div>
    </div>

        <div class="row bg-dark text-white">
            <div class="col-sm-1">ID: </div>
            <div class="col-sm-2">Numer: </div>
            <div class="col-sm-2">Powierzchnia: </div>
            <div class="col-sm-2">Właściciel:</div>
            <div class="col-sm-1"></div>
            <div class="col-sm-1">Za:</div>
            <div class="col-sm-1">Przeciw:</div>
            <div class="col-sm-1">Wstrzymał się:</div>
            <div class="col-sm-1"></div>

        </div>
        <div class="w-100"></div>
<%--    <form:form action="addVote" modelAttribute="voting" method="post">--%>
        <c:forEach items="${flats}" var="flats">
<%--            <form:input type="hidden" path="id"/><br>--%>
            <div class="row rowstriped border-left border-right">
                <div class="col-sm-1">${flats.id}</div>
                <div class="col-sm-2">${flats.flatNumber}</div>
                <div class="col-sm-2">${flats.area}</div>
                <div class="col-sm-2">${flats.authorizedVoter.surname}</div>
                <div class="col-sm-1"></div>
                <div class="col-sm-1">
<%--                    <form:checkbox path="votesFor"></form:checkbox>--%>
                </div>
                <div class="col-sm-1">
<%--                    <form:checkbox path="votesAgainst"></form:checkbox>--%>
                </div>
                <div class="col-sm-1">
<%--                    <form:checkbox path="votesAbstain"></form:checkbox>--%>
                </div>
                <div class="col-sm-1"></div>
            </div>
            <div class="w-100 border-bottom"></div>
        </c:forEach>


<%--        <input type="submit" name="apply" value="Zatwierdz">
    </form:form>--%>





</div>
</body>
</html>
