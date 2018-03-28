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
    <title>Ajouter oeuvre</title>
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
                              name='identification' method="post" action="insererOeuvre">
                            <div class="card-body">
                                <!--Header-->
                                <div class="text-center">
                                    <h3 class="white-text">Ajouter une oeuvre</h3>
                                    <hr class="hr-light">
                                </div>
                                <!--Body-->
                                <div class="md-form">
                                    <label for="titre" class="active white-text"> Titre de l'oeuvre </label>
                                    <INPUT type="text" class="form-control amber-text" name="txttitre" id="titre">
                                </div>
                                <div class="md-form">
                                    <label for="prix" class="active white-text"> Prix </label>
                                    <INPUT type="number" step="0.01" min="0" class="form-control amber-text" name="txtprix" id="prix">
                                </div>
                                <div>
                                    <br/>
                                    <select class="form-control browser-default" name="txtproprietaire" id="proprietaire">
                                        <option class="amber-text" selected disabled hidden>Sélectionnez propriétaire</option>
                                        <c:forEach items="${proprietaires}" var="prop">
                                            <option class="amber-text" value="${prop.idProprietaire}">${prop.nomProprietaire} ${prop.prenomProprietaire}</option>
                                        </c:forEach>
                                    </select></div>
                                </div>
                                <div class="text-center mt-4">
                                    <button type="submit" name="bt" class="btn btn-default">Ajouter</button>
                                    <button type="reset" name="bt" class="btn btn-default">RAZ</button>
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
