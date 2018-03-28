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
    <title>Liste oeuvres</title>
</head>

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
                    <table border="0" class="table table-hover text-center card" style="background-color:rgba(0, 0, 0, 0.3); max-height: 100% ; overflow-y: auto ; overflow-x: hidden">
                        <thead class="thead-light">
                        <tr class="row justify-content-center">
                            <th class="col" scope="col">Titre</th>
                            <th class="col" scope="col">Prix</th>
                            <th class="col" scope="col">Propriétaire</th>
                            <th class="col" scope="col">Gérer oeuvre</th>
                        </tr>
                        </thead>
                        <tbody class="white-text">
                        <c:forEach items="${mesOeuvres}" var="oeuvre">
                            <tr class="row justify-content-center">
                                <td class="col" scope="row">${oeuvre.titreOeuvrevente}</td>
                                <td class="col">${oeuvre.prixOeuvrevente}</td>
                                <td class="col">${oeuvre.proprietaire.getNomProprietaire()} ${oeuvre.proprietaire.getPrenomProprietaire()}</td>
                                <td class="col">
                                    <form method="post">
                                        <button type="submit" name="reserv" value="${oeuvre.idOeuvrevente}" formaction="ajouterReservation"
                                                class="btn purple-gradient btn-sm ${(oeuvre.etatOeuvrevente=="L")? "active":"disabled"}">Réserver</button>
                                        <button type="submit" name="modif" value="${oeuvre.idOeuvrevente}" formaction="modifierOeuvre"
                                                class="btn aqua-gradient btn-sm">Modifier</button>
                                        <button type="submit" name="suppr" value="${oeuvre.idOeuvrevente}" formaction="supprimerOeuvre"
                                                class="btn peach-gradient btn-sm">Supprimer</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table></div>
                </div>
            </div>
        </div>
    </div>
</div>
</header>
<jsp:include page="footer.jsp"/>
</body>
</html>
