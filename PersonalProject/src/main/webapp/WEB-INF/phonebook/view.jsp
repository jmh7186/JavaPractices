<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container mt-3">
		<button type="button" class="btn btn-success"
			onclick="location.href='/phonebook/pagelist'">홈</button>
		<h2>전화번호부 출력</h2>
		<form action="update.jsp">
			<div class="mb-3 mt-3">
				<label></label> <input type="text" class="form-control"
					id="idx" name="idx" readonly value="${p.idx}">
			</div>
			<div class="mb-3 mt-3">
				<label>이름:</label> <input type="text"
					class="form-control" id="name" name="name" readonly value="${p.name}">
			</div>
			<div class="mb-3 mt-3">
				<label>전화번호:</label> <input type="text"
					class="form-control" id="hp" name="hp" readonly value="${p.hp}">
			</div>
			<div class="mb-3 mt-3">
				<label>직장:</label> <input type="text"
					class="form-control" id="company" name="company" readonly value="${p.company}">
			</div>
			<div class="mb-3 mt-3">
				<label>이메일:</label> <input type="text"
					class="form-control" id="email" name="email" readonly value="${p.email}">
			</div>
			<div class="mb-3 mt-3">
				<label>주소:</label> <input type="text"
					class="form-control" id="address" name="address" readonly value="${p.address}">
			</div>
			<div class="mb-3 mt-3">
				<label>생일:</label> <input type="text"
					class="form-control" id="birthday" name="birthday" readonly value="${p.birthday}">
			</div>
			<div class="mb-3 mt-3">
				<label>메모:</label> <input type="text"
					class="form-control" id="memo" name="memo" readonly value="${p.memo}">
			</div>

			<button type="submit" class="btn btn-primary" onclick="location.href='/phonebook/update?idx=${p.idx}'">수정</button>
			<button type="button" class="btn btn-danger" onclick="pbdelete()">삭제</button>
		</form>
	</div>
	<script>
	function pbdelete() {
		var isok = confirm('삭제하시겠습니까?');
		if(isok) {
			location.href='/phonebook/delete?idx=${p.idx}';
		}
	}
	</script>