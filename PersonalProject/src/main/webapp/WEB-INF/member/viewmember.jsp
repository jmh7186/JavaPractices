<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="container mt-3">
		<button type="button" class="btn btn-success"
			onclick="location.href='/'">홈</button>
		<h2>회원 정보</h2>
		<form action="/member/updateProc" method="POST" onsubmit="return confirmsignup()">
			<div class="mb-3 mt-3">
				<label>아이디:</label> <input type="text" class="form-control" id="idview" name="idview" disabled value="${member.mid}">
				<label>아이디:</label> <input type="text" class="form-control" id="id" name="mid" hidden readonly value="${member.mid}">
			</div>
			<div class="mb-3 mt-3">
				<label>비밀번호:</label>
				<input type="password" class="form-control" id="pwd" name="mpwd" disabled readonly value="${member.mpwd}">
				<input type="button" id="updatePwdBtn" hidden class="btn btn-primary" onclick="updatePwd()" value="비밀번호 변경">
				<input type="password" class="form-control" id="repwd" hidden name="repwd" placeholder="비밀번호 확인">
				<input type="button" class="btn btn-info" id="pcon" hidden onclick="_confirmpwd()" value="비밀번호 검증">
			</div>
			<div class="mb-3 mt-3">
				<label>전화번호:</label> <input type="text"
					class="form-control" id="hp" name="mhp" disabled value="${member.mhp}">
			</div>
			<div class="mb-3 mt-3">
				<label>주소:</label> <input type="text"
					class="form-control" id="adr" name="madr" disabled value="${member.madr}">
			</div>
			<div id="defaultBtns">
				<button type="button" class="btn btn-primary" onclick="mbupdate()">수정</button>
				<button type="button" class="btn btn-danger" onclick="mbdelete()">삭제</button>
			</div>
			<div id="updateBtns" hidden>
				<button type="submit" class="btn btn-success">수정완료</button>
				<button type="button" class="btn btn-danger" onclick="location.reload()">취소</button>
			</div>
		</form>
	</div>
	<script>
	var pcon = true;
	function mbdelete() {
		var isok = confirm('삭제하시겠습니까?');
		if(isok) {
			location.href='/member/deleteProc?id=${member.mid}';
		}
	}
	function mbupdate () {
		document.getElementById("hp").disabled=false;
		document.getElementById("adr").disabled=false;
		document.getElementById("pwd").disabled=false;
		document.getElementById("defaultBtns").hidden=true;
		document.getElementById("updateBtns").hidden=false;
		document.getElementById("updatePwdBtn").hidden=false;
	}
	function updatePwd() {
		document.getElementById("pwd").readOnly=false;
		document.getElementById("updatePwdBtn").hidden=true;
		document.getElementById("repwd").hidden=false;
		document.getElementById("pcon").hidden=false;
		document.getElementById("pwd").disabled=false;
		document.getElementById("pwd").value="";
		document.getElementById("pwd").placeholder="새로운 비밀번호";
		pcon = false;
	}
	function _confirmpwd() {
		pcon = confirmpwd();
	}
	</script>