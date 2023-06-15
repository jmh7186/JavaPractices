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
        width: 600px;
	}
</style>
<div id="list">
	<h2>회원매출조회</h2>
	<table border="1">
		<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
		<c:forEach var="s" items="${sales}">
			<tr>
				<td>${s.custno}</td>
				<td>${s.custname}</td>
				<td>
					<c:choose>
						<c:when test="${s.grade=='A'}">VIP</c:when>
						<c:when test="${s.grade=='C'}">직원</c:when>
						<c:otherwise>일반</c:otherwise>
					</c:choose>
				</td>
				<td>${s.sales}</td>
			</tr>
		</c:forEach>
	</table>
</div>