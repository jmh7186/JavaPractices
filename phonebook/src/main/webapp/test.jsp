<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<h1>구구단</h1>
<%-- 	<%
	String js = request.getParameter("dan");
	if (js == "" || js == null) {
		js = "2";
		%><b>입력값이 존재하지 않아 2단으로 대체합니다.</b><%
		}
	int j = Integer.parseInt(js);
	%> --%>
	<p>
		<%
		for (int i = 2; i < 10; i++) {
		%>
		<h2><%=i%>단</h2>
		<%
			for (int j = 1; j < 10; j++) {
		%>
			<%=i%> × <%=j%> = <%=i * j%><br>
		<%
			}
			%><hr><%
		}
		%>
 	</p>
</body>
</html>