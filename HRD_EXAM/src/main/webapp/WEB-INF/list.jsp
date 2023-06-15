<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<style>
	#list table {
		text-align: center;
        margin-right: auto;
        margin-left: auto;
        width: 800px;
	}
</style>
<div id="list">
	<h2>회원목록조회/수정</h2>
	<table border="1">
		<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
		<c:forEach var="m" items="${member}">
			<tr>
				<td><a href="#" onclick="pageChange('section','/update?custno=${m.custno}')">${m.custno}</a></td>
				<td>${m.custname}</td>
				<td>${m.phone}</td>
				<td>${m.address}</td>
				<td>${m.joindate}</td>
				<td>${m.grade}</td>
				<td>${m.city}</td>
			</tr>
		</c:forEach>
	</table>
</div>