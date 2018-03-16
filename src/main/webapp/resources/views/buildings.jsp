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
        <td>
            ID: ${building.id}<br>
            Adres: ${building.adres}<br>
            Powierzchnia: ${building.area}<br>
            Liczba mieszkań: ${building.flatCount}<br>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>


</body>
</html>
