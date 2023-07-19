<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt3">
		<h1>전화번호부</h1>
		<div class="input-group mt-3 mb-3">
			<button id="searchbtn" type="button"
				class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
				id="selbtn" name="selbtn">검색 선택</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" onclick="selkind('이름')">이름</a></li>
				<li><a class="dropdown-item" onclick="selkind('전화번호')">전화번호</a></li>
				<li><a class="dropdown-item" onclick="selkind('직장')">직장</a></li>
				<li><a class="dropdown-item" onclick="selkind('전체검색')">전체검색</a></li>
			</ul>
			<input id="search" type="text" class="form-control" id="search"
				placeholder="검색..." name="search">
			<button onclick="search()" type="button" class="btn btn-info"
				id="searchbtn" name="searchbtn">검색</button>
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
					<c:forEach var="pb" items="${pagelist.list}">
						<tr onclick="location.href='/phonebook/view?idx=${pb.idx}'">
							<td>${pb.idx}</td>
							<td>${pb.name}</td>
							<td>${pb.hp}</td>
							<td>${pb.company}</td>
							<td>${pb.email}</td>
							<td>${pb.address}</td>
							<td>${pb.birthday}</td>
							<td>${pb.memo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container mt-3">
				<ul class="pagination">
					<c:if test="${pagelist.currentPage>=10}">
						<li class="page-item"><a class="page-link" href="/phonebook/pagelist?page=${pagelist.startPage-1}">Previous</a></li>
					</c:if>
					<c:forEach var="i" begin="${pagelist.startPage}" end="${pagelist.endPage}" step="1">
						<c:choose>
						<c:when test="${pagelist.currentPage==i}">
							<li class="page-item active"><a class="page-link" href="/phonebook/pagelist?page=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/phonebook/pagelist?page=${i}">${i}</a></li>
						</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pagelist.endPage!=pagelist.totalPage}">
						<li class="page-item"><a class="page-link" href="/phonebook/pagelist?page=${pagelist.endPage+1}">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<button onclick="location.href='/phonebook/insert'"
			class="btn btn-warning">전화번호 추가</button>
	</div>
</body>