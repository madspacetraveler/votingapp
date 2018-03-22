<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły Mieszkania</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
<div class="container justify-content-lg-center">
    Szczegóły właściciela:
    <div class="w-100"></div>
    ID: ${owner.id}
    <div class="w-100"></div>
    ${owner.name} ${owner.surname}
    <div class="w-100"></div>
</div>
<jsp:include page="include/footer.jsp" />
</body>
</html>
