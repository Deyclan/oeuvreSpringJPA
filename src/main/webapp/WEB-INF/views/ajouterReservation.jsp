<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Ajouter réservation</title>
</head>
<body>
<h2 class="text-center">Gestion des oeuvres</h2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Ajouter une réservation </H3>
<DIV>
    <FORM class="form-horizontal" name='identification' method="post">
        <INPUT  type="hidden" class="form-control" name="txtIDOeuvre" id="id" value="${oeuvreAModifier.idOeuvrevente}">
        <div class="form-group">
            <label class="control-label col-sm-3" for="titre"> Titre de l'oeuvre : </label>
            <div class="col-sm-5">
                <INPUT type="text" class="form-control" name="txttitre" id="titre" value="${oeuvreAModifier.titreOeuvrevente}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="prix">Prix : </label>
            <div class="col-sm-5">
                <INPUT type="number" step="0.01" min="0" class="form-control" name="txtprix" id="prix" value="${oeuvreAModifier.prixOeuvrevente}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="date">Date réservation : </label>
            <div class="col-sm-5">
                <INPUT type="date" class="form-control" name="txtdate" id="date" value="${oeuvreAModifier.prixOeuvrevente}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="adherent">Adhérent :</label>
            <div class="col-sm-5">
                <INPUT class="form-control" name="txtadherent" id="adherent" readonly>
            </div>
        </div>
        <button type="submit" formaction="Controleur?action=ajouterReservation" name="bt" class="btn btn-default">Réserver</button>
        <button type="submit" formaction="Controleur?action=listerOeuvre" name="bt" class="btn btn-info">Annuler</button>
    </FORM>
</DIV>
</body>
</html>
