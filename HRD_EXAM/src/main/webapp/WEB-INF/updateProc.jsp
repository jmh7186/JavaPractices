<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if (${result}>0) {
		alert('회원수정이 완료되었습니다!');
		location.href='/';
	}else {
		alert('오류가 발생했습니다.');
		history.back();
	}
</script>