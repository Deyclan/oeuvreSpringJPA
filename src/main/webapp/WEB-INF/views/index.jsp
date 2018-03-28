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
    <title>Expo : Médiathèque De POLYTECH</title>
</head>

<body>
<header>
    <jsp:include page="menuIndex.jsp"/>

    <!-- Full Page Intro -->
    <div class="view jarallax" data-jarallax='{"speed": 0.2}' style="background-image: url('resources/image/coffee.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 mb-4 white-text text-center">
                        <h2 class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown" data-wow-delay="0.3s"><strong>Médiathèque de POLYTECH</strong></h2>
                        <hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s">
                        <h5 class="text-uppercase mb-4 white-text wow fadeInDown" data-wow-delay="0.4s"><strong>Gestion de l'exposition 2016</strong></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<jsp:include page="footer.jsp"/>
</body>
</html>