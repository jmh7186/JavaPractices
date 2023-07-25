<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Index</title>
	<script src="/resource/js/main.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>
	<script src="https://kit.fontawesome.com/d210744c0d.js"></script>
	<link rel="icon" href="/resource/favicon.ico">
</head>
<body>
	<header><jsp:include page="/WEB-INF/home/header.jsp" /></header>
	<div id="middle">
		<main><jsp:include page="/WEB-INF/${mainpage}" /></main>
	</div>
	<footer><jsp:include page="/WEB-INF/home/footer.jsp" /></footer>
</body>
<link href="/resource/css/style.css" rel="stylesheet" type="text/css">
</html>