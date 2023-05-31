<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

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
			onclick="location.href='list.jsp'">홈</button>
		<h2>전화번호입력</h2>
		<form action="insertProc.jsp" class="was-validated">
			<div class="mb-3 mt-3">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">전화번호:</label> <input type="text"
					class="form-control" id="hp" placeholder="Enter hp" name="hp" required
					maxlength="13">
			</div>
			<div class="mb-3 mt-3">
				<label for="직장">직장:</label> <input type="text"
					class="form-control" id="company" placeholder="Enter company" name="company" >
			</div>
			<div class="mb-3 mt-3">
				<label for="이메일">이메일:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter email" name="email" >
			</div>
			<div class="mb-3 mt-3">
				<label for="주소">주소:</label> <input type="text"
					class="form-control" id="address" placeholder="Enter address" name="address">
			</div>
			<div class="mb-3 mt-3">
				<label for="생일">생일:</label> <input type="date"
					class="form-control" id="birthday" placeholder="Enter birthday" name="birthday">
			</div>
			<div class="mb-3 mt-3">
				<label for="memo">메모:</label> <input type="text"
					class="form-control" id="memo" placeholder="Enter memo" name="memo">
			</div>

			<button type="submit" class="btn btn-primary">전화번호입력</button>
		</form>
	</div>

</body>
</html>