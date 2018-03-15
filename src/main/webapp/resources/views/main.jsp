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
</head>
<body>

<p>test</p>
<c:forEach items="${buildings}" var="building">
    <tr>
        <td>${building.adres}</td>
        <td>${building.area}</td>
        <td>${building.flat_count}</td>
    </tr>
</c:forEach>
</tbody>

</body>
</html>
