<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<div class="container mt-3">
	<button type="button" class="btn btn-success"
		onclick="location.href='/phonebook/pagelist'">홈</button>
	<h2>전화번호부 출력</h2>
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
		<input type="button" class="btn btn-primary" id="sbtn" onclick="pbupdateProc()" hidden=true value="저장" />
		<input type="button" class="btn btn-info" id="cbtn" onclick="location.reload()" hidden=true value="취소" />
		<input type="button" class="btn btn-danger" onclick="pbdelete()" value="삭제" />
</div>
<script>
	function pbdelete() {
		var isok = confirm('삭제하시겠습니까?');
		if (isok) {
			fetch("delete",{
				method: "DELETE",
				body: document.getElementById("idx").value
			})
			.then(response => {return response.text();})
			.then(result => {
				if(result==1) {
					alert("삭제되었습니다.");
					location.href="pagelist";
				}else {
					alert("오류가 발생했습니다.");
				}
			});
		}
	}
	function pbupdate() {
		document.getElementById("name").disabled = false;
		document.getElementById("hp").disabled = false;
		document.getElementById("company").disabled = false;
		document.getElementById("email").disabled = false;
		document.getElementById("address").disabled = false;
		document.getElementById("birthday").disabled = false;
		document.getElementById("birthday").type = "date";
		document.getElementById("memo").disabled = false;
		document.getElementById("ubtn").hidden = true;
		document.getElementById("sbtn").hidden = false;
		document.getElementById("cbtn").hidden = false;
	}
	function pbupdateProc() {
		var idx = document.getElementById("idx").value;
		var name = document.getElementById("name").value;
		var hp = document.getElementById("hp").value;
		var company = document.getElementById("company").value;
		var email = document.getElementById("email").value;
		var address = document.getElementById("address").value;
		var birthday = document.getElementById("birthday").value;
		var memo = document.getElementById("memo").value;
		
		if(name==null || hp==null || name=="" || hp=="") {
			alert("이름과 전화번호는 필수로 입력해야 합니다.");
			return;
		}
		
		fetch("update",{
			method: "PUT",
			headers: {
				"Content-Type":"application/json",
				"Accept" : "application/json"
				},
			body: JSON.stringify({
				"idx":idx,
				"name":name,
				"hp":hp,
				"company":company,
				"email":email,
				"address":address,
				"birthday":birthday,
				"memo":memo
			})
		})
		.then(response => {return response.text();})
		.then(result => {
			if(result==1) {
				alert("수정되었습니다.");
				location.reload();
			}else {
				alert("오류가 발생했습니다.");
			}
		});
		
	}
</script>