<%@page import="jdbc.DBConn"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = DBConn.getConnection();
PreparedStatement ps = conn.prepareStatement("select * from emp where empno>=? and empno<?");
ps = conn.prepareStatement("select * from emp where empno like ?");
ps.setString(1, "75%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
	out.print(rs.getString("empno")+" / ");
	out.println(rs.getString("ename")+"<br>");
}
%>