<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
PreparedStatement pstat = conn.prepareStatement("select * from member where mid=? and mpwd=?");
String id = request.getParameter("id");
String pwd = request.getParameter("password");
pstat.setString(1, id);
pstat.setString(2, pwd);
ResultSet rs = pstat.executeQuery();
if(rs.next()) {
	//application.setAttribute("id", id); //전역변수 개념(웹 어플리케이션에 종료될때까지 유지됨)
	//request.setAttribute("id", id); //지역변수 개념(이 페이지에서 나가면 사라짐)
	session.setAttribute("id", id); //세션이 종료될 때 까지 유지됨
	//session.setMaxInactiveInterval(5*60); //세션 유지 제한시간 설정
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
		location.href='/login';
	</script>
	<%
}
%>