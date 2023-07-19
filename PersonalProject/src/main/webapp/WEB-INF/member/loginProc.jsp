<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean result = (boolean) request.getAttribute("result");
String id = (String) request.getAttribute("id");
if(result) {
	session.setAttribute("id", id); //세션이 종료될 때 까지 유지됨
	%>
	<script>
		alert('로그인 성공');
		location.replace("/");
	</script>
	<%
}else{
	%>
	<script>
		alert('아이디 또는 비밀번호를 확인하세요.');
		location.href='/member/login';
	</script>
	<%
}
%>