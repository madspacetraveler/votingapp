<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>VotingApp</title>
    <jsp:include page="include/resurces.jsp"/>
</head>
<body>
<jsp:include page="include/menu.jsp" />
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-sm-3">
                <div class="col-md-12 bg-dark text-white border border-dark rounded-top text-center">
                    Uchwały
                </div>
            </div>
            <div class="col-sm-3">
                <div class="col-md-12 bg-dark text-white border border-dark rounded-top text-center">
                    Budynki
                </div>
            </div>
            <div class="col-sm-3">
                <div class="col-md-12 bg-dark text-white border border-dark rounded-top text-center">
                    Mieszkania
                </div>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col-sm-3">
                <div class="col-md-12  bg-lightgrey border border-dark rounded-bottom">
                    Głosowano ${resolutions.countVotings()} razy<br>
                    Przyjęto ${resolutions.countResolutions()} uchwał<br>
                    Odrzucono ${resolutions.countVotings()-resolutions.countResolutions()} uchwał<br>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="col-md-12 bg-lightgrey border border-dark rounded-bottom">
                    Ilość budynków: ${buildings.countBuildings()}<br>
                    Łączna powierzchnia: ${flats.allFlatsArea()}<br>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="col-md-12 bg-lightgrey border border-dark rounded-bottom">
                    Łącznie mieszkań: ${flats.countFlats()}<br>
                    Srednia pow. mieszkania: ${flats.allFlatsArea()/flats.countFlats()}
                </div>
            </div>
        </div>
    </div>
<jsp:include page="include/footer.jsp" />
</body>
</html>
