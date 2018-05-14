<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły Mieszkania</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
<div class="container justify-content-xl-center">
    <table id="myTable" class="table">
        <tr class="header bg-dark text-white">
            <th scope="col-sm-1" class="text-center">Szczegóły właściciela</th>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark">ID: ${owner.id}</td>
        </tr>
        <tr scope="row" class="row-striped border-left border-right border-bottom text-dark">
            <td class="text-dark"> ${owner.name} ${owner.surname}</td>
        </tr>
    </table>
</div>
<jsp:include page="include/footer.jsp" />
</body>
</html>
