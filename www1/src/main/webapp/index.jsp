<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>
	
	<script src="https://kit.fontawesome.com/d210744c0d.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
	<link rel="stylesheet" href="/style.css">
	<script>
		$.getScript("/main.js");
	</script>
</head>

<body>
	<div>
		<nav class="navbar">
			<div class="navbar_logo" onclick="location.href='/'">
				<i class="fab fa-accusoft"></i>
			</div>
			<ul class="navbar_menu">
				<li onmouseenter="pageChange('aside','company.html')">회사소개</li>
				<li onmouseenter="pageChange('aside','info.html')">사업안내</li>
				<li onclick="pageChange('main','list.jsp')">전화번호부</li>
				<li onmouseenter="pageChange('aside','gallary.html')">갤러리</li>
				<li onmouseenter="pageChange('aside','board.html')">게시판</li>
			</ul>
			<ul class="navbar_icon">
				<li><i class="fas fa-camera"></i></li>
				<li><i class="fas fa-envelope"></i></li>
				<li onclick="pageChange('main','login.html')"><i class="fas fa-user-plus"></i></li>
			</ul>
			<a class="navbar_toogleBtn" href="#"> <i class="fas fa-bars"></i>
			</a>
		</nav>
		<div id="middle">
			<aside></aside>
			<main>
				<h1 style="text-align: center;">메인</h1>
			</main>
		</div>
		<footer>
			<p>주식회사 어쩌구저쩌구</p>
			<p>사업자 등록번호 : 000-0000-0000 | 대표 : 김아무개</p>
			<p>00000 서울특별시 어쩌구 어쩔동</p>
			<p>고객센터 : 02-000-0000</p>
		</footer>
	</div>
</body>

</html>