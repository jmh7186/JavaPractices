<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- pagelist라는 객체의 데이터만 표현(VIEW) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<main>
		<div class="container mt-3">
			<h2 id="headertitle">${b.tab+1}번째 답글작성</h2>
			<form action="/replyProc" method="post" enctype="multipart/form-data">

				<lable for="writeid" hidden>작성자 ID</lable>
				<input type="text" id="writeid" name="writeid" class="form-control" hidden>
				
				<lable for="writename">작성자</lable>
				<input type="text" id="writename" name="writename" class="form-control">

				<lable for="title">제목</lable>
				<input type="text" id="title" name="title" class="form-control" value="">

				<lable for="content">내용</lable>
				<input type="text" id="content" name="content" class="form-control">

				<lable for="file">첨부파일</lable>
				<input type="file" id="filename" name="filename" class="form-control">

				<button type="submit" class="btn btn-primary">답글게시</button>
				<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>

				<input hidden type="text" name="parentid" value="${b.idx}">
				<input hidden type="text" name="tab" value="${b.tab+1}">
			</form>
		</div>
	</main>
</body>
<script>
	document.getElementById("title").placeholder="${b.title}의 답글 작성...";
</script>
</html>
