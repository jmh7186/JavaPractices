<meta charset="UTF-8">
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("password");
	String tel = request.getParameter("tel");
	String adr = request.getParameter("address");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	PreparedStatement pstat = conn.prepareStatement("insert into member values(?,?,?,?)");
	
	pstat.setString(1, id);
	pstat.setString(2, pwd);
	pstat.setString(3, tel);
	if(adr.equals("")) adr=null;
	pstat.setString(4, adr);
	
	if(pstat.executeUpdate()>0) {
		%>
		<script>
			alert("회원가입이 완료되었습니다.");
			location.replace("/");
		</script>
		<%
	}else {
		%>
		<script>
			alert("오류가 발생했습니다.");
			history.back();
		</script>
		<%
	}
	pstat.close();
	conn.close();
%>