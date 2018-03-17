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
    <title>VotingApp</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Witamy w systemie do głosowania dla wspólnot mieszkaniowych</h1>

<ul>
    <li><a href="buildings">Przeglądaj listę budynków</a></li>
    <li><a href="resolutions">Podjęte uchwały</a></li>
    <li><a href="votings">Głosowania</a></li>

</ul>




</body>
</html>
