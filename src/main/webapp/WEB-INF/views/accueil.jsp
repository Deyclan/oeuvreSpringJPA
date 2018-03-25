<!-- TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Gestion des oeuvres</title>
</head>
<body>
    <h2 class="text-center">Gestion des oeuvres</h2>
    <br/>
<jsp:include page="menu.jsp"/>
<br/>
    <h3 class="text-center">Bienvenue</h3>

    <div>
    <p>Vous pourrez ici gérer les oeuvres : en ajouter, y consulter le catalogue, les modifier.</p>
    <p>Vous pourrez aussi gérer les réservations.</p>

</div>
</body>
</html>