<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="w-100"></div>
    <div class="row justify-content-xl-center">
        <div class="btn-group btn-group-sm mb-3 justify-content-xl-center">
            <a href="${pageContext.servletContext.contextPath}/votings" class="btn btn-info">Wszystkie</a>
            <a href="${pageContext.servletContext.contextPath}/votings/accepted" class="btn btn-info">Uchwalone</a>
            <a href="${pageContext.servletContext.contextPath}/votings/rejected" class="btn btn-info">Odrzucone</a>
            <a href="${pageContext.servletContext.contextPath}/votings/byBuilding" class="btn btn-info">Szukaj wg Budynku</a>
        </div>
    </div>
