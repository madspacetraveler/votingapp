<%--
  Created by IntelliJ IDEA.
  User: cinus
  Date: 18-03-17
  Time: 23:08
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
    <div class="row justify-content-xl-center">
        <div class="col">
            <h2>Lista mieszkań: </h2>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-1">ID: </div>
        <div class="col-sm-2">powierzchnia:</div>
        <div class="col-sm-2">buildingid: </div>
        <div class="col-sm-2">ownerid</div>
        <div class="col-sm-2">numer mieszkania</div>
        <div class="w-100"></div>
    </div>
    <c:forEach items="${flats}" var="flat">
        <div class="row">
            <div class="col-sm-1">${flat.id}</div>
            <div class="col-sm-2">${flat.area}</div>
            <div class="col-sm-2">${flat.buildingId}</div>
            <div class="col-sm-2">${flat.authorizedVoter}</div>
            <div class="col-sm-2">${flat.flatNumber}
       <%--     <c:if test="${flat.id==}"--%>
            </div>
            <div class="w-100"></div>
        </div>
    </c:forEach>

</div>



</body>
</html>
