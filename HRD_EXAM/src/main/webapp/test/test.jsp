<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
PreparedStatement ps = conn.prepareStatement("select * from emp where empno>=? and empno<?");
ps = conn.prepareStatement("select * from emp where empno like ?");
ps.setString(1, "75%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
	System.out.print(rs.getString("empno")+" / ");
	System.out.println(rs.getString("ename"));
}
%>