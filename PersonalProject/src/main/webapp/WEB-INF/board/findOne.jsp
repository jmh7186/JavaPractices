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
			<h2 id="headertitle">글 상세보기[수정/삭제/댓글달기]-조회수${b.viewcount+1}</h2>
			<form action="/updateProc" method="post"
				enctype="multipart/form-data">

				<lable for="idx">글번호:</lable>
				<input type="text" id="idx" name="idx" class="form-control" readonly
					value="${b.idx}">

				<lable for="writeName">작성자</lable>
				<input type="text" id="writeName" name="writeName"
					class="form-control" readonly value="${b.writeid}">

				<lable for="title">제목</lable>
				<input type="text" id="title" name="title" class="form-control"
					readonly value="${b.title}">

				<lable for="content">내용</lable>
				<input type="text" id="content" name="content" class="form-control"
					readonly value="${b.content}">

				<lable for="file">첨부파일</lable>
				<input type="text" id="filename" name="filename"
					class="form-control" readonly value="${b.filename}">
				<input type="button" id="reupbtn" value="파일 재업로드" hidden>
				<br>
				<div id="defaultBtns">
					<input type="button" class="btn btn-primary" value="수정">
					<input type="button" class="btn btn-primary" value="삭제">
					<input type="button" class="btn btn-primary" value="댓글쓰기">
					<input type="button" class="btn btn-primary" value="취소">
					<input type="button" class="btn btn-info" id="fileopen" value="첨부파일 열기" hidden>
				</div>
				<div id="updateBtns" hidden>
					<input type="submit" class="btn btn-primary" value="수정하기">
					<input type="button" class="btn btn-danger" value="취소">
				</div>
			</form>
		</div>
	</main>
</body>
<script>
	window.onload = function () {
		if(${b.filename!=null}) {
			document.getElementById("fileopen").hidden = false;
		}
	}

	document.getElementById("defaultBtns").addEventListener('click',function (event) {
		if (event.target.value=="수정") {
			document.getElementById("title").readOnly = false;
			document.getElementById("content").readOnly = false;
			document.getElementById("defaultBtns").hidden = true;
			document.getElementById("updateBtns").hidden = false;
			document.getElementById("reupbtn").hidden = false;
		}else if (event.target.value=="삭제") {
			var isok = confirm("삭제할까요?");
			if(isok) {
				location.href="/deleteProc?idx=${b.idx}";
			}
		}else if (event.target.value=="댓글쓰기") {
			location.href="/replyForm?idx=${b.idx}";
		}else if (event.target.value=="취소") {
			history.back();
		}else if (event.target.value=="첨부파일 열기") {
			window.open("http://localhost:8080/uploadedFiles/${b.filename}", "_blank", "width=500, height=500");
		}
	});
	
	document.getElementById("updateBtns").addEventListener('click',function (event) {
		if(event.target.value=="취소") {
			 location.reload();
		}
	});
	
	document.getElementById("reupbtn").addEventListener('click',function (event) {
		document.getElementById("reupbtn").hidden = true;
		document.getElementById("filename").type = "file";
	});
	
	
</script>
</html>