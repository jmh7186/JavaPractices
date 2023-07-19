<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
	<form action="/signup/signupProc" id="signup" method="post" onsubmit="return confirmsignup()">
		<ul>
			<li><h1>회원가입</h1></li>
			<li style="color:red;"><b><sup>*</sup>필수 입력</b></li>
			<li><sup style="color:red"><b>*</b></sup>아이디<br><input type="text" id="id" name="id"></li>
			<li><sup style="color:red"><b>*</b></sup>비밀번호<br><input type="password" id="pwd" name="pwd"></li>
			<li><sup style="color:red"><b>*</b></sup>비밀번호 확인<br><input type="password" id="repwd" name="repwd"></li>
			<li><input type="button" id="pcon" name="pcon" value="비밀번호 검증" onclick="confirmpwd()"></li>
			<li><sup style="color:red"><b>*</b></sup>전화번호<br><input type="tel" id="hp" name="hp"></li>
			<li>주소<br><input type="text" id="adr" name="adr"></li>
			<li>
				<input type="submit" value="회원가입">
				<input type="reset" id="reset" name="reset" value="취소" onclick="location.href='/signup'">
			</li>
		</ul>
	</form>
