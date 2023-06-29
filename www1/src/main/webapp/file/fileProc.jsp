<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%=request.getParameter("text")%><br>
<%=request.getParameter("file")%><br>
<%
InputStream in = request.getInputStream();
int data=-1;
while ((data=in.read())!=-1) {
	out.print((char)data);
}
%>