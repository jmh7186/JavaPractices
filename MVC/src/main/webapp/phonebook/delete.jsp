<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
int idx = Integer.parseInt(request.getParameter("idx"));
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
PreparedStatement pstat = conn.prepareStatement("select * from phonebook where idx=?");
pstat.setInt(1, idx);
ResultSet rs = pstat.executeQuery();
String name=null;
String hp=null;
String company=null;
String email=null;
String address=null;
String birthday="-";
String memo=null;
if(rs.next()) {
	idx = rs.getInt("idx");
	name = rs.getString("name");
	hp = rs.getString("hp");
	company = rs.getString("company"); if(company==null) company = "-";
	email = rs.getString("email"); if(email==null) email = "-";
	if(rs.getString("birthday")!=null){
		Date _birthday = formatter.parse(rs.getString("birthday"));
		birthday = formatter.format(_birthday);
	}
	address = rs.getString("address"); if(address==null) address = "-";
	memo = rs.getString("memo"); if(memo==null) memo = "-";
}
rs.close();
pstat.close();
conn.close();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>전화번호 입력</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-3">
		<button type="button" class="btn btn-success"
			onclick="location.href='/list'">홈</button>
		<h2>전화번호부 삭제</h2>
		<form action="deleteProc.jsp">
			<div class="mb-3 mt-3">
				<label for="num">번호:</label> <input type="text" class="form-control"
					id="idx" name="idx" readonly value="<%=idx%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="name">이름:</label> <input type="text"
					class="form-control" readonly value="<%=name%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">전화번호:</label> <input type="text"
					class="form-control" readonly value="<%=hp%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">직장:</label> <input type="text"
					class="form-control" readonly value="<%=company%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">이메일:</label> <input type="text"
					class="form-control" readonly value="<%=email%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">주소:</label> <input type="text"
					class="form-control" readonly value="<%=address%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">생일:</label> <input type="text"
					class="form-control" readonly value="<%=birthday%>">
			</div>
			<div class="mb-3 mt-3">
				<label for="memo">메모:</label> <input type="text"
					class="form-control" readonly value="<%=memo%>">
			</div>
    
    <button type="submit" class="btn btn-danger">삭제</button>
    <button type="button" class="btn btn-warning" onclick="history.back()">취소</button>
  </form>
</div>

</body>
</html>