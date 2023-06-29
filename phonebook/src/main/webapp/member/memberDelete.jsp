<%@page import="dao.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDAO mdao = new MemberDAO();
String keyword = request.getParameter("keyword");
switch(mdao.deleteById(keyword)){
case 1: //성공
	%>
	<script>
		alert('삭제했습니다.');
		history.back();
	</script>
	<%
	break;
case 3: //값 없음
	%>
	<script>
		alert('일치하는 아이디를 찾을 수 없습니다.');
		history.back();
	</script>
	<%
	break;
case 2: //값 비어있음
	%>
	<script>
		alert('값을 입력하세요.');
		history.back();
	</script>
	<%
	break;
default: //오류
	%>
	<script>
		alert('오류가 발생했습니다.');
		history.back();
	</script>
	<%
	break;
}
%>