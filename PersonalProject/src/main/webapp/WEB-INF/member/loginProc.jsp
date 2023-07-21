<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${result}==1) {
		location.href="/";
	}else {
		alert('아이디 또는 비밀번호를 확인하세요.');
		location.href="/member/login";
	}
</script>