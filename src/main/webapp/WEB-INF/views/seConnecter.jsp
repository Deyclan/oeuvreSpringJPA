<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/mdb.min.css">
    <link rel="stylesheet" href="resources/css/myCSS.css">
    <title>Connexion</title>
</head>
<body>

<header>
    <jsp:include page="menuIndex.jsp"/>
    <div class="view" style="background-image: url('resources/image/coffee.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-md-6 col-xl-5 mb-4">
                        <!--Form-->
                        <form class="card wow fadeInDown" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInDown; animation-delay: 0.3s; background-color:rgba(0, 0, 0, 0.2);"
                              name='connexion' method="post" action="seConnecter">
                            <div class="card-body">
                                <!--Header-->
                                <div class="text-center">
                                    <h3 class="white-text"> Connexion </h3>
                                    <hr class="hr-light">
                                </div>
                                <!--Body-->
                                <div class="md-form">
                                    <label for="user" class="active white-text"> Identifiant (NOM) </label>
                                    <INPUT type="text" class="form-control amber-text" name="username" value="" id="user">
                                </div>
                                <div class="md-form">
                                    <label for="pwd" class="active white-text"> Mot de passe (PRENOM) </label>
                                    <INPUT type="password" class="form-control amber-text" name="password" id="pwd">
                                </div>
                                <div class="text-center mt-4">
                                    <button type="submit" name="bt" class="btn btn-default text-center">Se connecter</button>
                                    <button type="reset" name="bt" class="btn btn-default text-center">RAZ</button>
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
