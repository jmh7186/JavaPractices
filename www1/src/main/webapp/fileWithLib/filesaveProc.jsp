<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");
//외부 라이브러리 사용 (request, 실제 경로, 파일의 최대 사이즈, 인코딩 형식, 정책 필요)
MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\git\\JavaPractices\\www1\\src\\main\\webapp\\img",1024*1024*5,new DefaultFileRenamePolicy());
//mr.getFile();
Enumeration<?> files = mr.getFileNames();
String filename="";
String fileparam="";
while(files.hasMoreElements()) {
	fileparam = (String)files.nextElement();
	filename = mr.getFilesystemName(fileparam);
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<img src="">
</body>
	<script>
		window.addEventListener('DOMContentLoaded', function() {
			document.querySelector("img").src = '/www1/img/<%=filename%>';
		});
	</script>
</html>