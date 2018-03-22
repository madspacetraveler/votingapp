<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rozpoczęcie głosowania</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
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
<jsp:include page="include/footer.jsp" />
</body>
</html>
