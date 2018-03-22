<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row justify-content-xl-center">
    <div class="row">
        <div class="row justify-content-xl-center">
        <h3>System do głosowania dla wspólnot mieszkaniowych</h3>
        </div>
    </div>
    <div class="w-100"></div>
    <div class="row justify-content-xl-center">
        <div class="btn-group btn-group-lg mb-3 justify-content-xl-center">
            <a href="${pageContext.servletContext.contextPath}/" class="btn btn-info">Strona główna</a>
            <div class="btn-group btn-group-lg">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                    Zasoby <span class="caret"></span></button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/buildings">Budynki</a>
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/flats">Mieszkania</a>
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/owners">Właściciele</a>
                </div>
            </div>
            <div class="btn-group btn-group-lg">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                    Uchwały <span class="caret"></span></button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/votings">Wszystkie</a>
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/votings?id=approved">Zatwierdzone</a>
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/votings?id=rejected">Odrzucone</a>
                </div>
            </div>
            <div class="btn-group btn-group-lg">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                    Głosowanie <span class="caret"></span></button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/preVoteForm">Rozpocznij</a>
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/votingHistory">Historia</a>
                </div>
            </div>
        </div>
    </div>
</div>