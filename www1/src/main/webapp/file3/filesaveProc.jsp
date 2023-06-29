<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
MultipartRequest mr = new MultipartRequest(request, "C:/Users/admin/git/JavaPractices/www1/src/main/webapp/file3/img", 1024 * 1024 * 5,"UTF-8" ,new DefaultFileRenamePolicy());
/* String test = mr.getParameter("input");
String[] values = mr.getParameterValues("text");
for (String s:values) {
	out.print(s+"<br>");
}
Enumeration<?> em = mr.getParameterNames();
while (em.hasMoreElements()) {
	out.print(mr.getParameter(em.nextElement().toString())+"<br>");
} */
/* Enumeration<?> files = mr.getFileNames();
while (files.hasMoreElements()) {
	String tagname = (String) files.nextElement();
	//파일명을 리턴하고 그 파일을 저장하는 기능을 가지고 있는 함수
	String filename = mr.getFilesystemName(tagname);
	String orinfname = mr.getOriginalFileName(tagname);
	out.print(tagname+"<br>");
	out.print(filename+"<br>");
	out.print(orinfname+"<br>");
} */
%>
