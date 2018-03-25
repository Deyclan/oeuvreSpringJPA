<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/myCSS.css">
	<script src="resources/js/bootstrap.min.js"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="0;URL=javascript:fermer();">
<title>Expo : Médiathèque De POLYTECH</title>
</head>


<script language="JavaScript">
	function fermer() {
	}
</script>

<body>
	<h2 class="text-center">Médiathèque de POLYTECH</h2>
	<h3 class="text-center">Gestion de l'exposition 2016</h3>
	<div><p> Sélectionnez la fonctionnalité voulue:	</p></div>
	<div class="list-group">
		<a href="ajouterAdherent" class="list-group-item">Ajout Adhérent</a>
		<a href="listerAdherent" class="list-group-item">Lister les adhérents</a>
		<a href="gererOeuvre" class="list-group-item">Gestion des oeuvres</a>
		<a href="javascript:fermer()" class="list-group-item">Quitter</a>
	</div>
</body>
</html>