<%@page import="phonebook.PhonebookDAO"%>
<%@page import="phonebook.PhonebookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!-- forEach를 사용하기 위한 라이브러리 설정 -->
<!-- 라이브러리에 JSTL을 추가해야 사용할 수 있음 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<PhonebookVO> list = new PhonebookDAO().findAll();
request.setAttribute("data", list); //자바 코드 없이 사용하기 위한 설정
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>전화번호부</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script>
  	function selkind(kind) {
  		document.querySelector("#searchbtn").innerText=kind;
  	}
  	
  	function search() {
  		kind=document.querySelector("#searchbtn").innerText;
  		svalue=document.querySelector("#search").value;
  		location.href="searchList.jsp?kind="+kind+"&search="+svalue;
  	}
  </script>
</head>

<body>
  <div class="container mt3">
    <h1>전화번호부</h1>
    <div class="input-group mt-3 mb-3">
      <button id="searchbtn" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" id="selbtn" name="selbtn">
        검색 선택
      </button>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" onclick="selkind('이름')">이름</a></li>
        <li><a class="dropdown-item" onclick="selkind('전화번호')">전화번호</a></li>
        <li><a class="dropdown-item" onclick="selkind('직장')">직장</a></li>
        <li><a class="dropdown-item" onclick="selkind('전체검색')">전체검색</a></li>
      </ul>
      <input id="search" type="text" class="form-control" id="search" placeholder="검색..." name="search">
      <button onclick="search()" type="button" class="btn btn-info" id="searchbtn" name="searchbtn">검색</button>
    </div>
    <div class="container mt-3">
      <table class="table">
        <thead class="table-light">
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>직장</th>
            <th>이메일</th>
            <th>주소</th>
            <th>생일</th>
            <th>메모</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="i" begin="0" end="10" step="1">
          	<tr onclick="location.href='/phonebook/view.jsp?idx=${data[i].idx}'">
            	<td>${data[i].idx}</td>
            	<td>${data[i].name}</td>
            	<td>${data[i].hp}</td>
            	<td>${data[i].company}</td>
            	<td>${data[i].email}</td>
            	<td>${data[i].birthday}</td>
            	<td>${data[i].address}</td>
            	<td>${data[i].memo}</td>
          	</tr>
        	</c:forEach>
        </tbody>
      </table>
    </div>
    <button onclick="location.href='insert.jsp'" class="btn btn-warning">전화번호 추가</button>
  </div>
</body>
</html>