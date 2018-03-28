<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/mdb.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <title>Affichage de tous les adhérents</title>
</head>
<body>
<header>
    <jsp:include page="menuIndex.jsp"/>
    <div class="view" style="background-image: url('resources/image/heart.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-md-12 my-3">
                        <div style="height:700px">
                        <!--Table-->
                        <TABLE BORDER="0" class="table table-hover text-center card" style="background-color:rgba(0, 0, 0, 0.3); max-height: 100% ; overflow-y: auto; overflow-x: hidden">
                        <thead class="thead-light">
                        <TR class="row justify-content-center">
                            <TH class="col" scope="col">Numéro</TH>
                            <TH class="col" scope="col">Nom</TH>
                            <TH class="col" scope="col">Prénom</TH>
                            <TH class="col" scope="col">Ville</TH>
                            <th class="col" scope="col">Gérer adhérent</th>

                        </TR>
                        </thead>
                        <tbody class="white-text">
                        <c:forEach items="${mesAdherents}" var="adhe">
                            <tr class="row justify-content-center">
                                <td class="col" scope="row">${adhe.idAdherent}</td>
                                <td class="col">${adhe.nomAdherent}</td>
                                <td class="col">${adhe.prenomAdherent}</td>
                                <td class="col">${adhe.villeAdherent}</td>
                                <td class="col">
                                    <form method="post">
                                        <button type="submit" name="modifier" value="${adhe.idAdherent}" formaction="modifierAdherent"
                                                class="btn purple-gradient btn-sm" >Modifier</button>
                                        <button type="submit" name="supprimer" value="${adhe.idAdherent}" formaction="supprimerAdherent"
                                                class="btn peach-gradient btn-sm">Supprimer</button>
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