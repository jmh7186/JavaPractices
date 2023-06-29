<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\git\\JavaPractices\\www1\\src\\main\\webapp\\img",5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
Enumeration<?> em = mr.getFileNames(); //input:file 태그의 name 값을 모두 가져옴
String filename="";
while (em.hasMoreElements()) {
	filename = mr.getFilesystemName((String)em.nextElement()); //태그의 name값이 같은 파일이 시스템에 저장된 이름을 가져옴
}
%>
<%=filename%>