<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>VotingApp</title>
    <jsp:include page="../include/resurces.jsp"/>
</head>
<body>
<jsp:include page="../include/menu.jsp" />
<div class="container justify-content-xl-center">
    <div class="row pl-5">
        <h4>Budynek: ${voting.building.adres}</h4>
        <div class="w-100"></div>
    </div>

        <form:form action="apply" modelAttribute="voting" method="post">
            <form:input type="hidden" path="building.area"/>
            <form:input type="hidden" path="building.id"/>
            <form:input type="hidden" path="building.adres"/>
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Nr uchwały</span>
                </div>
                <form:input path="resolution" type="text" class="form-control" placeholder="Nr uchwały" aria-label="Nr uchwały" aria-describedby="basic-addon1"/><br>
            </div>
            <c:if test="${validator.resolutionLength.length()>0}">
                <div class="alert alert-warning">${validator.resolutionLength}<br></div>
            </c:if>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon2">Tytuł</span>
                </div>
                <form:input path="title" type="text" class="form-control" placeholder="Tytuł" aria-label="Tytuł" aria-describedby="basic-addon1"/><br>
            </div>
            <c:if test="${validator.titleLength.length()>0}">
                <div class="alert alert-warning">${validator.titleLength}<br></div>
            </c:if>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Treść uchwały</span>
                </div>
                    <form:textarea path="content" type="textarea" class="form-control" aria-label="Treść uchwały"/><br>
            </div>
            <c:if test="${validator.content.length()>0}">
                <div class="alert alert-warning">${validator.content}<br></div>
            </c:if>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">Moderator</span>
                </div>
                <form:select path="moderator" type="select" class="form-control" placeholder="Sekretarz" aria-label="Sekretarz" aria-describedby="basic-addon4">
                    <form:option value="none">--Wybierz sekretarza--</form:option>
                    <form:options items="${persons}"></form:options>
                </form:select>
            </div>
            <c:if test="${validator.moderator.length()>0}">
                <div class="alert alert-warning">${validator.moderator}<br></div>
            </c:if>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon4">Sekretarz</span>
                </div>
                <form:select path="secretary" type="select" class="form-control" placeholder="Sekretarz" aria-label="Sekretarz" aria-describedby="basic-addon4">
                    <form:option value="none">--Wybierz sekretarza--</form:option>
                    <form:options items="${persons}"></form:options>
                </form:select>
            </div>
            <c:if test="${validator.secretary.length()>0}">
                <div class="alert alert-warning">${validator.secretary}<br></div>
            </c:if>
    <div class="row justify-content-xl-center">
        <div class="col">
            <h4>Lista mieszkań: </h4>
        </div>
    </div>
        <div class="row bg-dark text-white">
            <div class="col-sm-1">ID: </div>
            <div class="col-sm-1">Numer: </div>
            <div class="col-sm-2">Powierzchnia: </div>
            <div class="col-sm-4">Właściciel:</div>
            <div class="col-sm-1">Za:</div>
            <div class="col-sm-1">Przeciw:</div>
            <div class="col-sm-2">Wstrzymał się:</div>
        </div>
        <div class="w-100"></div>
        <c:forEach items="${voting.flatVoteDtoList}" var="flat" varStatus="flatStatus">
            <div class="row row-striped border-left border-right">
                <div class="col-sm-1">${flat.id}</div>
                <div class="col-sm-1">${flat.flatNumber}</div>
                <div class="col-sm-2">${flat.area}</div>
                <div class="col-sm-4">${flat.authorizedVoter.name} ${flat.authorizedVoter.surname}</div>
                <div class="col-sm-1 pt-1">
                    <form:checkbox path="flatVoteDtoList[${flatStatus.index}].votesFor"></form:checkbox> <%--Dont trust IntelliJ that it doesnt work, it works.--%>
                </div>
                <div class="col-sm-1 pt-1">
                    <form:checkbox path="flatVoteDtoList[${flatStatus.index}].votesAgainst"></form:checkbox>
                </div>
                <div class="col-sm-2 pt-1">
                    <form:checkbox path="flatVoteDtoList[${flatStatus.index}].votesAbstain"></form:checkbox>
                </div>
                <form:input type="hidden" path="flatVoteDtoList[${flatStatus.index}].area"/>
                <div class="w-100"></div>
            </div>
        </c:forEach>
            <c:if test="${validator.checkboxes.length()>0}">
                <div class="alert alert-warning">${validator.checkboxes}<br></div>
            </c:if>
            <div class="w-100"></div>
            <div class="row justify-content-xl-center col-sm-12 mb-3 center-block">
                <input type="submit" name="apply" value="Zatwierdź" class="btn btn-success btn-lg m-3">
                <a href="${pageContext.servletContext.contextPath}/preVoteForm" class="btn btn-danger btn-lg m-3">Anuluj</a>
            </div>

        </form:form>
</div>
<jsp:include page="../include/footer.jsp" />
</body>
</html>
