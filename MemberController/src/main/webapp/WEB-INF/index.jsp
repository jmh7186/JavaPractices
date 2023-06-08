<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Index</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>
	<script src="https://kit.fontawesome.com/d210744c0d.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
	<script src="/js/main.js"></script>
	<link rel="icon" href="/resource/favicon.ico">
	<!-- jQuery 코드와 JavaScript 코드가 혼용되어 있을 경우 둘 다 로드하면
	문제가 발생할 수 있으므로 각각 파일을 나누기를 권장 -->
</head>

<body>
	<header><jsp:include page="/WEB-INF/home/header.jsp" /></header>
	<div id="middle">
		<aside><jsp:include page="/WEB-INF/${asidepage}" /></aside>
		<main><jsp:include page="/WEB-INF/${mainpage}" /></main>
	</div>
	<footer><jsp:include page="/WEB-INF/home/footer.jsp" /></footer>
</body>
<link href="/css/style.css" rel="stylesheet" type="text/css">
</html>