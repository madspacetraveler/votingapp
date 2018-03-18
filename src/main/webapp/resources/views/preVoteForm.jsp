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
    <title>Rozpoczęcie głosowania</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="menu.jsp" />

<div class="container justify-content-xl-center">
<h4>Wybierz budynek dla którego chcesz przeprowadzić głosowanie:</h4>

    <c:forEach items="${buildings}" var="building">
        <div class="row row-striped border-left border-right">
            <div class="col-sm-1">${building.id}</div>
            <div class="col-sm-6"><a href="voteForm/${building.id}">${building.adres}</a> </div>
            <div class="w-100 border-bottom"></div>
        </div>
    </c:forEach>
</div>
</body>
</html>
