<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session.setMaxInactiveInterval(1);
session.invalidate(); //세션 초기화
//response.sendRedirect("/");
%>
<script>
	alert("로그아웃되었습니다.");
	location.href="/";
</script>