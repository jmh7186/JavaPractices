<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
out.println(conn);
PreparedStatement ps = conn.prepareStatement("select * from member_tbl_02 where custno=100002");
ResultSet rs = ps.executeQuery();
if(rs.next()) {
	out.println(rs.getString(1));
	out.println(rs.getString(2));
	out.println(rs.getString(3));
	out.println(rs.getString(4));
}
%>