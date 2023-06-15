<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<style>
form>table {
	text-align: center;
	font-weight: bolder;
	width: 500px;
	margin-right: auto;
	margin-left: auto;
}

form input[type=text] {
	float: left;
}
</style>
<h2>홈쇼핑 회원 정보 수정</h2>
<div id="updateForm">
	<form action="/updateProc" onsubmit="return signupValidate()">
		<table border="1">
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="idx" id="idx" size="10"
					value="${member.custno}" readonly></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input type="text" name="name" id="name" size="10"
					value="${member.custname}"></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type="text" name="hp" id="hp" size="13"
					value="${member.phone}"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" name="adr" id="adr" size="20"
					value="${member.address}"></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="text" name="date" id="date" size="10"
					value="${member.joindate}" readonly></td>
			</tr>
			<tr>
				<td>고객등급 [A:VIP,B:일반,C:직원]</td>
				<td><input type="text" name="rank" id="rank" size="10"
					value="${member.grade}"></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type="text" name="city" id="city" size="10"
					value="${member.city}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value=" 수 정 "> <input
					type="button" onclick="pageChange('section','/list')" value=" 조 회 "></td>
			</tr>
		</table>
	</form>
</div>