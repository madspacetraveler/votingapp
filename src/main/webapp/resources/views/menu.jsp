
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="row justify-content-xl-center">
    <div class="row">
        <h1>--- System do głosowania dla wspólnot mieszkaniowych ---</h1>
    </div>
    <div class="w-100"></div>

    <div class="row justify-content-xl-center">

        <div class="btn-group btn-group-lg mb-3">
            <a href="${pageContext.servletContext.contextPath}/" class="btn btn-info">Strona Głowna</a>
            <a href="buildings" class="btn btn-info">Przeglądaj listę budynków</a>
            <a href="resolutions" class="btn btn-info">Podjęte uchwały</a>
            <a href="flats" class="btn btn-info">Lista mieszkań</a>
            <div class="btn-group btn-group-lg">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                    Głosowania <span class="caret"></span></button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="preVoteForm">Rozpocznij</a>
                    <a class="dropdown-item" href="votingHistory">Historia</a>
                </div>
            </div>
        </div>

    </div>

<%--
    <div class="row">
        <a href="${pageContext.servletContext.contextPath}/" class="btn btn-secondary">Strona Głowna</a>
    </div>--%>

</div>

