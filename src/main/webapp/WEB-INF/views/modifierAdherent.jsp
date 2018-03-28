<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- TODO : Ajouter la possibilité de modifier l'adhérent avec bouton annuler (page jsp? + Controleur + ServiceConnexion) -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/mdb.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <title>Modifier un adhérent</title>
</head>


<body>
<header>
    <jsp:include page="menuIndex.jsp"/>
    <div class="view" style="background-image: url('resources/image/book.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-md-6 col-xl-5 mb-4">
                        <!--Form-->
                        <form class="card wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; background-color:rgba(0, 0, 0, 0.2);"
                              name='identification' method="post" action="sauvegarderAdherent">
                            <div class="card-body">
                                <!--Header-->
                                <div class="text-center">
                                    <h3 class="white-text"> Modifier un adhérent</h3>
                                    <hr class="hr-light">
                                    <INPUT type="hidden" class="form-control amber-text" name="txtid" value="${adherentAModifier.idAdherent}" id="id">
                                </div>
                                <!--Body-->
                                <div class="md-form">
                                    <label for="nom" class="active white-text"> Nom de l'adhérent </label>
                                    <INPUT type="text" class="form-control amber-text" name="txtnom" value="${adherentAModifier.nomAdherent}" id="nom">
                                </div>
                                <div class="md-form">
                                    <label for="prenom" class="active white-text"> Prénom de l'adhérent </label>
                                    <INPUT type="text" class="form-control amber-text" name="txtprenom" value="${adherentAModifier.prenomAdherent}" id="prenom">
                                </div>
                                <div class="md-form">
                                    <label for="ville" class="active white-text"> Ville de l'adhérent </label>
                                    <INPUT type="text" class="form-control amber-text" name="txtville" value="${adherentAModifier.villeAdherent}" id="ville">
                                </div>
                                <div class="text-center mt-4">
                                    <button type="submit" name="bt" class="btn btn-default">Modifier</button>
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