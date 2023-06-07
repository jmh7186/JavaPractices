<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar">
	<div class="navbar_logo" onclick="location.href='/'">
		<i class="fab fa-accusoft"></i>
	</div>
	<ul class="navbar_menu">
		<li onmouseenter="location.href='/company'">회사소개</li>
		<li onmouseenter="location.href='/info'">사업안내</li>
		<li onclick="location.href='/phonebook'">전화번호부</li>
		<li onmouseenter="location.href='/gallary'">갤러리</li>
		<li onmouseenter="location.href='/board'">게시판</li>
	</ul>
	<ul class="navbar_icon">
		<li><i class="fas fa-camera"></i></li>
		<li><i class="fas fa-envelope"></i></li>
		<%
		if (session.getAttribute("id") == null) {
		%>
		<li onclick="location.href='/login'"><i class="fas fa-user-plus"></i></li>
		<%
		} else {
		%>
		<li>환영합니다. <%=session.getAttribute("id")%>. <a
			style="color: white" href="/logout">[로그아웃]</a><br>
		</li>
		<%
		}
		%>
	</ul>
	<a class="navbar_toogleBtn" href="#"> <i class="fas fa-bars"></i>
	</a>
</nav>
