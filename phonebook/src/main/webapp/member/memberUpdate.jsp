<%@page import="member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String keyword = request.getParameter("keyword");
String newid = request.getParameter("newid");
String newhp = request.getParameter("newhp");
String newpwd = request.getParameter("newpwd");
String newadr = request.getParameter("newadr");
MemberDAO mdao = new MemberDAO();
switch(mdao.updateById(keyword, newid, newpwd, newhp, newadr)){
case 1: //성공
	%>
	<script>
		alert('수정했습니다.');
		history.back();
	</script>
	<%
	break;
case 2: //값 비어있음
	%>
	<script>
		alert('필수 입력값이 빠졌습니다.');
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
case 4: //값 중복
	%>
	<script>
		alert('새로운 아이디와 중복되는 아이디가 있습니다.');
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