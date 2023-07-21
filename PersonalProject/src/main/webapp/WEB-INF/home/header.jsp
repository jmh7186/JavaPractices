<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar">
	<div class="navbar_logo" onclick="location.href='/'">
		<i class="fab fa-accusoft"></i>
	</div>
	<ul class="navbar_menu">
		<li onclick="location.href='/phonebook/pagelist'">전화번호부</li>
		<li onclick="location.href='/gallary'">갤러리</li>
		<li onclick="location.href='/board/pagelist'">게시판</li>
		<li onclick="location.href='/chat'">채팅상담</li>
		<li onclick="location.href='/map'">오시는 길</li>
	</ul>
	<ul class="navbar_icon">
		<c:choose>
			<c:when test="${empty sessionScope.id}">
				<li onclick="location.href='/login'"><i	class="fas fa-user-plus"></i></li>
			</c:when>
			<c:otherwise>
				<li>환영합니다. <a style="color: white" href="/member/view?id=${sessionScope.id}">${sessionScope.id}.</a>
					<a style="color: white" href="/logoutProc">[로그아웃]</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
	<a class="navbar_toogleBtn" href="#"> <i class="fas fa-bars"></i>
	</a>
</nav>
