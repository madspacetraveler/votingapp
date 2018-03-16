<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 16.03.2018
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>building page</title>
</head>
<body>
<table>
    <thead>Lista budynków: </thead>
<tbody>
<c:forEach items="${buildings}" var="building">
    <tr>
        <td>ID: ${building.id}</td><br>
        <td>Adres: ${building.adres}</td><br>
        <td>Powierzchnia: ${building.area}</td><br>
        <td>Liczba mieszkań: ${building.flatCount}</td><br>
    </tr>
</c:forEach>
</tbody>
</table>


</body>
</html>
