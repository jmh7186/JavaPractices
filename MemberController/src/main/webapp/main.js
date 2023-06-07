function isChecked() {
		if (document.getElementById("checkbox").checked) {
			location.href='/signup';
		} else {
			alert('약관 동의에 체크해주세요.');
			return;
		}
}

function loginValidate() {
	if (document.getElementById("id").value == "") {
		alert('아이디 칸이 비어있습니다.')
		document.getElementById("id").focus();
		return;
	}
	if (document.getElementById("password").value == "") {
		alert('비밀번호 칸이 비어있습니다.');
		document.getElementById("password").focus();
		return;
	}
	document.forms[0].requestSubmit();
}

pcon = false;
function confirmpwd() {
	if (document.getElementById("password").value.length < 8 || document.getElementById("password").value.length > 20) {
		alert('비밀번호는 8자 이상 20자 이하여야 합니다.')
		document.getElementById("password").focus();
		return;
	}
	if (document.getElementById("repassword").value != document.getElementById("password").value) {
		alert('비밀번호 확인이 일치하지 않습니다.')
		document.getElementById("repassword").focus();
		return;
	} else {
		alert('비밀번호가 일치합니다.');
		document.getElementById("pcon").value = "일치함";
		document.getElementById("pcon").disabled = 'disabled';
		document.getElementById("repassword").disabled = 'disabled';
		document.getElementById("password").readOnly = true;
		document.getElementById("tel").focus();
		pcon = true;
	}
}
function confirm() {
	//공란확인
	if (document.getElementById("id").value == "") {
		alert('아이디 칸이 비어있습니다.')
		document.getElementById("id").focus();
		return false;
	}
	if (document.getElementById("id").value.length < 5 || document.getElementById("id").value.length > 12) {
		alert('아이디는 5자 이상 12자 이하여야 합니다.')
		document.getElementById("id").focus();
		return false;
	}
	if (document.getElementById("password").value == "") {
		alert('비밀번호 칸이 비어있습니다.')
		document.getElementById("password").focus();
		return false;
	}
	if (document.getElementById("tel").value == "") {
		alert('전화번호 칸이 비어있습니다.')
		document.getElementById("tel").focus();
		return false;
	}
	if (!(pcon)) {
		alert('비밀번호 검증을 하지 않았습니다.')
		document.getElementById("repassword").focus();
		return false;
	}
	return true;
}

function selkind(kind) {
	document.getElementById("searchbtn").innerText = kind;
}

function search() {
	kind = document.getElementById("searchbtn").innerText;
	svalue = document.getElementById("search").value;
	location.href = "searchList.jsp?kind=" + kind + "&search=" + svalue;
}