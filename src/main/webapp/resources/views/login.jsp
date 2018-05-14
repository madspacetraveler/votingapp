<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona logowania</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
<div class="container">
    <div class="row justify-content-sm-center">
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <div class="alert alert-danger">Błąd logowania! Spróbuj jeszcze raz.<br></div>
            ${SPRING_SECURITY_LAST_EXCEPTION.printStackTrace()}
        </c:if>
        <div class="w-100"></div>
        <form name='f' class="justify-content-sm-center" modelAttribute="login" action="login" method='POST'>
            <table class="justify-content-sm-center">
                <tr>
                    <td>
                    <div class="input-group mb-1">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Login</span>
                        </div>
                        <input type="text" name='username' class="form-control" placeholder="nazwa użytkownika" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    </td>
                </tr>
                <tr>
                    <td>
                    <div class="input-group mb-1">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon2">Hasło</span>
                        </div>
                        <input type="password" name='password' class="form-control" placeholder="hasło" aria-label="Password" aria-describedby="basic-addon2">
                    </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input name="submit" type="submit" value="Zaloguj się" class="btn btn-success btn-lg btn-block"/>
                        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<jsp:include page="include/footer.jsp" />
</body>
</html>
