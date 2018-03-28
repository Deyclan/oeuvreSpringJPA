<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
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
    <title>Ajouter réservation</title>
</head>
<body>
<header>
    <jsp:include page="menuOeuvre.jsp"/>
    <div class="view" style="background-image: url('resources/image/book.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-md-6 col-xl-5 mb-4">
                        <!--Form-->
                        <form class="card wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInUp; animation-delay: 0.3s; background-color:rgba(0, 0, 0, 0.2);"
                              name='identification' method="post">
                            <div class="card-body">
                                <!--Header-->
                                <div class="text-center">
                                    <h3 class="white-text">Ajouter une réservation</h3>
                                    <hr class="hr-light">
                                    <INPUT type="hidden" class="form-control amber-text" name="txtIDOeuvre" id="id" value="${oeuvreAReserver.idOeuvrevente}">
                                </div>
                                <!--Body-->
                                <div class="md-form">
                                    <label for="titre" class="active white-text"> Titre de l'oeuvre </label>
                                    <INPUT type="text" class="form-control amber-text" name="txttitre" id="titre" value="${oeuvreAReserver.titreOeuvrevente}" readonly>
                                </div>
                                <div class="md-form">
                                    <label for="prix" class="active white-text"> Prix </label>
                                    <INPUT type="number" step="0.01" min="0" class="form-control amber-text" name="txtprix" id="prix" value="${oeuvreAReserver.prixOeuvrevente}" readonly>
                                </div>
                                <div class="md-form">
                                    <label for="date" class="active white-text"> Date réservation </label>
                                    <INPUT type="date" class="form-control amber-text" name="txtdate" id="date">
                                </div>
                                <div>
                                    <select class="form-control browser-default" name="txtadherent" id="adherent">
                                        <option class="amber-text" selected disabled hidden> Sélectionnez adhérent </option>
                                        <c:forEach items="${adherents}" var="adhe">
                                            <option class="amber-text" value="${adhe.idAdherent}">${adhe.nomAdherent} ${adhe.prenomAdherent}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="text-center mt-4">
                                    <button type="submit" formaction="insererReservation" name="bt" class="btn btn-default">Réserver</button>
                                    <button type="submit" formaction="listerOeuvre" name="bt" class="btn btn-info">Annuler</button>
                                    <hr class="hr-light mb-3 mt-4">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<jsp:include page="footer.jsp"/>
</body>
</html>
