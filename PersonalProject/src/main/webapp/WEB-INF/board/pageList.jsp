<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#viewed:hover {
	background-color: rgb(230, 230, 230);
}
</style>
		<div class="container mt-3">
			<h2>
				일반게시판
			</h2>
			<div class="input-group mt-3 mb-3">
				<button name="kind" id="kind" type="button"
					class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
					검색선택</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#" onclick="selkind('title')">제목</a>
					<a class="dropdown-item" href="#" onclick="selkind('writeid')">글쓴이</a>
					<a class="dropdown-item" href="#" onclick="selkind('writeday')">날짜</a>
				</div>
				<input type="text" class="form-control" id="search" name="search">
				<input id="searchbtn" type="button" class="btn btn-info" value="검색" onclick="selfind()">
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="b" items="${pagelist.list}">
						<c:choose>
							<c:when test="${b.isdel!=1}">
								<tr onclick="location.href='/board/findone?idx=${b.idx}'" id="viewed">
									<td>${b.idx}</td>
									<td><c:forEach var="i" begin="1" end="${b.tab}" step="1">
											<img src="/img/reply_icon.gif">
										</c:forEach> ${b.title} <c:if test="${not empty b.filename}">
											<img src="/img/file.png" style="width: 16px; height: 16px;">
										</c:if></td>
									<td>${b.writeid}</td>
									<td>${b.writeday}</td>
									<td>${b.viewcount}</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr style="color: gray;">
									<td colspan="5">삭제된 글입니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</tbody>
			</table>

			<ul class="pagination">
				<c:if test="${pagelist.currentPage>=5}">
					<li class="page-item"><a class="page-link"
						href="/board/pagelist?page=${pagelist.startPage-1}">Previous</a></li>
				</c:if>
				<c:forEach var="i" begin="${pagelist.startPage}"
					end="${pagelist.endPage}" step="1">
					<c:choose>
						<c:when test="${pagelist.currentPage==i}">
							<li class="page-item active"><a class="page-link"
								href="/board/pagelist?page=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="/board/pagelist?page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pagelist.endPage!=pagelist.totalPage}">
					<li class="page-item"><a class="page-link"
						href="/board/pagelist?page=${pagelist.endPage+1}">Next</a></li>
				</c:if>
			</ul>


			<button type="button" class="btn btn-success"
				onclick="location.href='/board/writeform'">글쓰기</button>
		</div>
<script>
	function selkind (kind) {
		if (kind=='title') {
			document.getElementById("kind").innerText='제목';
		}else if (kind=='writeid') {
			document.getElementById("kind").innerText='글쓴이';
		}else if (kind=='writeday') {
			document.getElementById("kind").innerText='날짜';
		} 
	}
	function selfind () {
		var kind = document.getElementById("kind").innerText;
		var keyword = document.getElementById("search").value;
		if (kind=='제목') {
			location.href="/board/findlist?kind=title&keyword="+keyword;
		}else if (kind=='글쓴이') {
			location.href="/board/findlist?kind=writeid&keyword="+keyword;
		}else if (kind=='날짜') {
			location.href="/board/findlist?kind=writeday&keyword="+keyword;
		}
	}
</script>