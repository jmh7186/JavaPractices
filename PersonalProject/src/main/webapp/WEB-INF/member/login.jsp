<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<div id="loginform">
	<form action="/member/loginProc" method="post" onsubmit="return loginValidate()">
		<ul style="list-style: none">
			<li><h1>LOGIN</h1></li>
			<li>아이디<br> <input type="text" name="id" id="id"></li>
			<li>비밀번호<br> <input type="password" name="pwd"
				id="pwd"></li>
			<li><input type="checkbox" name="rememlogin" id="rememlogin">로그인
				유지</li>
			<li><input type="submit" value="로그인" id="loginbtn"></li>
			<li><a href="/signup/contract" href="#">회원가입</a>|ID/PW찾기</li>
		</ul>
	</form>
</div>
