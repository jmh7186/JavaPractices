<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="was-validated" method="POST">
	<div class="container mt-3">
		<button type="button" class="btn btn-success"
			onclick="location.href='/phonebook/pagelist'">홈</button>
		<h2>전화번호입력</h2>
			<div class="mb-3 mt-3">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="전화번호">전화번호:</label> <input type="text"
					class="form-control" id="hp" placeholder="Enter hp" name="hp" required
					maxlength="13">
			</div>
			<div class="mb-3 mt-3">
				<label for="직장">직장:</label> <input type="text"
					class="form-control" id="company" placeholder="Enter company" name="company" >
			</div>
			<div class="mb-3 mt-3">
				<label for="이메일">이메일:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter email" name="email" >
			</div>
			<div class="mb-3 mt-3">
				<label for="주소">주소:</label> <input type="text"
					class="form-control" id="address" placeholder="Enter address" name="address">
			</div>
			<div class="mb-3 mt-3">
				<label for="생일">생일:</label> <input type="date"
					class="form-control" id="birthday" placeholder="Enter birthday" name="birthday">
			</div>
			<div class="mb-3 mt-3">
				<label for="memo">메모:</label> <input type="text"
					class="form-control" id="memo" placeholder="Enter memo" name="memo">
			</div>

			<input type="button" class="btn btn-primary" onclick="pbupdateProc()" value="전화번호 입력">
	</div>
</form>
<script>
function pbupdateProc() {
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
	
	fetch("insertProc",{
		method: "POST",
		headers: {
			"Content-Type":"application/json",
			"Accept" : "application/json"
			},
		body: JSON.stringify({
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
			alert("전화번호가 저장되었습니다.");
			location.href="/phonebook/pagelist";
		}else {
			alert("오류가 발생했습니다.");
		}
	});
	
}
</script>