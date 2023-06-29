<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//stream을 통해서 들어오는 데이터를 메모리에 저장하고 substring, indexof 추출
InputStream in = request.getInputStream();
FileOutputStream fout = new FileOutputStream(new File("D:/work/a.txt"));
int data = -1;
while ((data=in.read())!=-1) {
	fout.write(data);
}
fout.close();
in.close();
%>