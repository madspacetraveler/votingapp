<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>VotingApp</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container justify-content-xl-center">
    <div class="row pl-5">
        <h4>Budynek: ${voting.building.adres}</h4>
        <div class="w-100"></div>
    </div>
        <form:form action="apply" modelAttribute="voting" method="post">
            <form:input type="hidden" path="building.area"/><br>
            <form:input type="hidden" path="building.id"/><br>
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Nr uchwały</span>
                </div>
                <form:input path="resolution" type="text" class="form-control" placeholder="Nr uchwały" aria-label="Nr uchwały" aria-describedby="basic-addon1"/><br>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon2">Tytuł</span>
                </div>
                <form:input path="title" type="text" class="form-control" placeholder="Tytuł" aria-label="Tytuł" aria-describedby="basic-addon1"/><br>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Treść uchwały</span>
                </div>
                    <form:textarea path="content" type="textarea" class="form-control" aria-label="Treść uchwały"/><br>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">Moderator</span>
                </div>
                <form:input path="moderator" type="text" class="form-control" placeholder="Moderator" aria-label="Moderator" aria-describedby="basic-addon3"/><br>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon4">Sekretarz</span>
                </div>
                <form:input path="secretary" type="text" class="form-control" placeholder="Sekretarz" aria-label="Sekretarz" aria-describedby="basic-addon4"/><br>
            </div>
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
                    <form:checkbox path="flatVoteDtoList[${flatStatus.index}].votesFor"></form:checkbox>
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
            <div class="w-100"></div>
            <div class="row justify-content-xl-center col-sm-12 mb-3 center-block">
                <input type="submit" name="apply" value="Zatwierdź" class="btn btn-success btn-lg m-3">
                <input type="submit" name="cancel" value="Anuluj" class="btn btn-danger btn-lg m-3">
            </div>
        </form:form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
