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
String pwd = request.getParameter("pwd");
if(id.equals("") || pwd.equals("")){
	%>
	<script>
		alert('값을 입력하세요.');
		history.back();
	</script>
	<%
}
pstat.setString(1, id);
pstat.setString(2, pwd);
ResultSet rs = pstat.executeQuery();
if(rs.next()) {
	%>
	<script>
		alert('로그인 성공');
		location.href="index.html";
	</script>
	<%
}else{
	%>
	<script>
		alert('로그인 실패');
		history.back();
	</script>
	<%
}
	%>