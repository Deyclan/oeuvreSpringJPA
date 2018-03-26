<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Modifier oeuvre</title>
</head>
<body>
<h2 class="text-center">Gestion des oeuvres</h2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Modifier une oeuvre </H3>
<DIV>
    <FORM class="form-horizontal" name='identification' method="post" action="sauvegarderOeuvre">
        <INPUT  type="hidden" class="form-control" name="txtIDOeuvre" id="id" value="${oeuvreAModifier.idOeuvrevente}">
        <div class="form-group">
            <label class="control-label col-sm-3" for="titre"> Titre de l'oeuvre : </label>
            <div class="col-sm-5">
                <INPUT type="text" class="form-control" name="txttitre" id="titre" value="${oeuvreAModifier.titreOeuvrevente}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="prix">Prix : </label>
            <div class="col-sm-5">
                <INPUT type="number" step="0.01" min="0" class="form-control" name="txtprix" id="prix" value="${oeuvreAModifier.prixOeuvrevente}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="propietaire">Propriétaire :</label>
            <div class="col-sm-5">
                <select class="form-control" name="txtpropietaire" id="propietaire">
                    <c:forEach items="${proprietaires}" var="prop">
                        <option ${(oeuvreAModifier.proprietaireByIdProprietaire.getIdProprietaire() == prop.idProprietaire)? "selected": ""} id="${prop.idProprietaire}">${prop.nomProprietaire}</option>
                    </c:forEach>
                </select>

            </div>
        </div>
        <button type="submit" name="bt" class="btn btn-default">Modifier</button>
        <button type="reset" name="bt" class="btn btn-default">RAZ</button>
    </FORM>
</DIV>
</body>
</html>
