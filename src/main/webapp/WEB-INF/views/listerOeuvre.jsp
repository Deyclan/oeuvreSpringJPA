<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Liste oeuvres</title></head>
<body>

<H2 class="text-center"> Gestion des oeuvres </H2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Catalogue des oeuvres </H3>
<div>
    <TABLE BORDER="1" class="table table-responsive table-hover">
       <thead class="thead-light"> <TR>
            <TH scope="col">Titre</TH>
            <TH scope="col">Prix</TH>
            <TH scope="col">Prénom propriétaire</TH>
            <TH scope="col">Nom propriétaire</TH>
            <TH scope="col">Réserver/Modifier</TH>
        </TR></thead>
        <tbody>
        <c:forEach items="${mesOeuvres}" var="item">
            <tr>
                <td scope="row">${item.titreOeuvrevente}</td>
                <td>${item.prixOeuvrevente}</td>
                <td>${item.proprietaire.getNomProprietaire()}</td>
                <td>${item.proprietaire.getPrenomProprietaire()}</td>
                <td>
                    <form method="post">
                    <button type="submit" name="reserv" value="${item.idOeuvrevente}" formaction="ajouterReservation" class="btn btn-info ${(item.etatOeuvrevente=="L")? "active":"disabled"}">Réserver</button>
                    <button type="submit" name="modif" value="${item.idOeuvrevente}" formaction="modifierOeuvre" class="btn btn-warning">Modifier</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </TABLE>
</div>

</body>
</html>
