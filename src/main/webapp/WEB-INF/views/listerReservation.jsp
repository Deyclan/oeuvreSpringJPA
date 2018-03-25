<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Liste réservation</title></head>
<body>
<h2 class="text-center">Gestion des oeuvres</h2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Réservation </H3>
<div>
    <TABLE BORDER="1" class="table table-responsive table-hover">
        <thead class="thead-light"> <TR>
            <TH scope="col">Oeuvre réservée</TH>
            <TH scope="col">Adhérent</TH>
            <TH scope="col">Date</TH>
            <TH scope="col">Statut</TH>
            <TH scope="col">Confirmer/Annuler</TH>
        </TR></thead>
        <tbody>
        <c:forEach items="${mesReservations}" var="item">
            <tr>
                <td scope="row">${item.oeuvreventeByIdOeuvrevente.getTitreOeuvrevente()}</td>
                <td>${item.adherentByIdAdherent.getNomAdherent()} ${item.adherentByIdAdherent.getPrenomAdherent()}</td>
                <td>${item.dateReservation}</td>
                <td>${item.statut}</td>
                <td>
                    <form method="post">
                        <button type="submit" name="confirmer" value="${item.oeuvreventeByIdOeuvrevente.getIdOeuvrevente()}" formaction="confirmerReservation" class="btn btn-info ${(item.statut=="attente")? "active":"disabled"}">Confirmer</button>
                        <button type="submit" name="annuler" value="${item.oeuvreventeByIdOeuvrevente.getIdOeuvrevente()}" formaction="annulerReservation" class="btn btn-warning">Annuler réservation</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </TABLE>
</div></body>
</html>
