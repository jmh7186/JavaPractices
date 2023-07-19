<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<script>
	if(${result==1}) {
		alert("회원정보가 삭제되었습니다.");
		location.href="/";
	}else {
		alert("오류가 발생하여 처리에 실패했습니다. 오류 코드: ${result}");
		history.go(-2);
	}
</script>