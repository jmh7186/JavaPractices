<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<body>
	<main>
		<div class="container mt-3">
			<h2>글쓰기</h2>
			<form action="/writeProc" method="post" enctype="multipart/form-data">

				<input type="text" id="idx" name="idx" class="form-control"	hidden=true>

				<lable for="writeid">작성자 ID</lable>
				<input type="text" id="writeid" name="writeid"
					class="form-control" value="">
					
				<lable for="writeName">작성자</lable>
				<input type="text" id="writename" name="writename"
					class="form-control" value="">

				<lable for="title">제목</lable>
				<input type="text" id="title" name="title" class="form-control">

				<lable for="content">내용</lable>
				<input type="text" id="content" name="content" class="form-control">

				<lable for="file">첨부파일</lable>
				<input type="file" id="file" name="file" class="form-control">

				<button type="submit" class="btn btn-primary">게시</button>
				<button type="button" class="btn btn-primary">취소</button>
			</form>
		</div>
	</main>
</body>
</html>