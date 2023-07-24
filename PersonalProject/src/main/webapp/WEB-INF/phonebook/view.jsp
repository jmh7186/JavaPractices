<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container mt-3">
	<button type="button" class="btn btn-success"
		onclick="location.href='/phonebook/pagelist'">홈</button>
	<h2>전화번호부 출력</h2>
	<form action="update" method="post">
		<div class="mb-3 mt-3">
			<label></label> <input type="text" class="form-control" id="idx" name="idx" readonly value="${p.idx}" hidden=true>
		</div>
		<div class="mb-3 mt-3">
			<label>이름:</label> <input type="text" class="form-control" id="name" name="name" disabled value="${p.name}">
		</div>
		<div class="mb-3 mt-3">
			<label>전화번호:</label> <input type="text" class="form-control" id="hp" name="hp" disabled value="${p.hp}">
		</div>
		<div class="mb-3 mt-3">
			<label>직장:</label> <input type="text" class="form-control" id="company" name="company" disabled value="${p.company}">
		</div>
		<div class="mb-3 mt-3">
			<label>이메일:</label> <input type="text" class="form-control" id="email" name="email" disabled value="${p.email}">
		</div>
		<div class="mb-3 mt-3">
			<label>주소:</label> <input type="text" class="form-control" id="address" name="address" disabled value="${p.address}">
		</div>
		<div class="mb-3 mt-3">
			<label>생일:</label> <input type="text" class="form-control" id="birthday" name="birthday" disabled value="${p.birthday}">
		</div>
		<div class="mb-3 mt-3">
			<label>메모:</label> <input type="text" class="form-control" id="memo" name="memo" disabled value="${p.memo}">
		</div>

		<input type="button" class="btn btn-primary" onclick="pbupdate()" id="ubtn" value="수정" />
		<input type="submit" class="btn btn-primary" id="sbtn" hidden=true value="저장" />
		<input type="button" class="btn btn-info" id="cbtn" onclick="location.reload()" hidden=true value="취소" />
		<input type="button" class="btn btn-danger" onclick="pbdelete()" value="삭제" />
	</form>
</div>
<script>
	function pbdelete() {
		var isok = confirm('삭제하시겠습니까?');
		if (isok) {
			location.href = '/phonebook/delete?idx=${p.idx}';
		}
	}
	function pbupdate() {
		document.getElementById("name").disabled = false;
		document.getElementById("hp").disabled = false;
		document.getElementById("company").disabled = false;
		document.getElementById("email").disabled = false;
		document.getElementById("address").disabled = false;
		document.getElementById("birthday").disabled = false;
		document.getElementById("memo").disabled = false;
		document.getElementById("ubtn").hidden = true;
		document.getElementById("sbtn").hidden = false;
		document.getElementById("cbtn").hidden = false;
	}
</script>