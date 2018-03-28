<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/mdb.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <title>Liste réservation</title></head>
<body>
<header>
    <jsp:include page="menuOeuvre.jsp"/>
    <div class="view" style="background-image: url('resources/image/heart.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-md-12 my-3">
                        <div style="height:700px">
                        <!--Table-->
                        <TABLE BORDER="0" class="table table-hover card text-center" data-wow-delay="0.3s" style="background-color:rgba(0, 0, 0, 0.3); max-height: 100% ; overflow-y: auto; overflow-x: hidden">
                            <thead class="thead-light">
                            <TR class="row justify-content-center">
                                <TH class="col" scope="col">Oeuvre réservée</TH>
                                <TH class="col" scope="col">Adhérent</TH>
                                <TH class="col" scope="col">Date</TH>
                                <TH class="col" scope="col">Confirmer/Annuler</TH>
                            </TR>
                            </thead>
                            <tbody class="white-text">
                            <c:forEach items="${mesReservations}" var="reserv">
                                <tr class="row justify-content-center">
                                    <td class="col" scope="row">${reserv.oeuvreventeByIdOeuvrevente.getTitreOeuvrevente()}</td>
                                    <td class="col">${reserv.adherentByIdAdherent.getNomAdherent()} ${reserv.adherentByIdAdherent.getPrenomAdherent()}</td>
                                    <td class="col">${reserv.dateReservation}</td>
                                    <td class="col">
                                        <form method="post">
                                            <button type="submit" name="confirmer"
                                                    value="${reserv.oeuvreventeByIdOeuvrevente.getIdOeuvrevente()}"
                                                    formaction="confirmerReservation"
                                                    class="btn purple-gradient btn-sm ${(reserv.statut=="attente")? "active":"disabled"}">Confirmer
                                            </button>
                                            <button type="submit" name="annuler"
                                                    value="${reserv.oeuvreventeByIdOeuvrevente.getIdOeuvrevente()}"
                                                    formaction="annulerReservation" class="btn peach-gradient btn-sm">Annuler réservation
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </TABLE></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<jsp:include page="footer.jsp"/>
</body>
</html>
