<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${result}==-1) {
		alert('아이디가 중복됩니다.');
		history.back();
	}else {
		alert('오류가 발생했습니다.');
		location.href="/member/login";
	}
</script>