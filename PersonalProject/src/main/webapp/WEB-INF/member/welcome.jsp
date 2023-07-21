<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="welcome">
	<h1>회원가입이 완료되었습니다.</h1>
	<p>환영합니다. ${id}님.</p>
	<button type="button" class="btn btn-success" onclick="location.href='/'">홈으로</button>
	<button type="button" class="btn btn-primary" onclick="location.href='/member/view?id=${id}'">회원 정보 확인</button>
</div>