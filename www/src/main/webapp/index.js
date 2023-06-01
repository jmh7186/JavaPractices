function pageChange(page, location) {
    fetch(location)
        .then(res => res.text())
        .then(html => document.querySelector(page).innerHTML = html);
}
function isChecked() {
    if (document.querySelector("#checkbox").checked) {
        pageChange('main', './member/memberValidate.html');
    } else {
        alert('약관 동의에 체크해주세요.')
        return;
    }
}
pcon = false;
function confirm() {
    //공란확인
    if (document.querySelector("#id").value == "") {
        alert('아이디 칸이 비어있습니다.')
        document.querySelector("#id").focus();
        return false;
    }
    if (document.querySelector("#id").value.length < 5 || document.querySelector("#id").value.length > 12) {
        alert('아이디는 5자 이상 12자 이하여야 합니다.')
        document.querySelector("#id").focus();
        return false;
    }
    if (document.querySelector("#password").value == "") {
        alert('비밀번호 칸이 비어있습니다.')
        document.querySelector("#password").focus();
        return false;
    }
    if (document.querySelector("#tel").value == "") {
        alert('전화번호 칸이 비어있습니다.')
        document.querySelector("#tel").focus();
        return false;
    }
    if (document.querySelector("#address").value == "") {
        alert('주소 칸이 비어있습니다.')
        document.querySelector("#address").focus();
        return false;
    }
    if (!(pcon)) {
        alert('비밀번호 검증을 하지 않았습니다.')
        document.querySelector("#repassword").focus();
        return false;
    }
    document.forms[0].requestSubmit();
}
function confirmpwd() {
    if (document.querySelector("#password").value.length < 8 || document.querySelector("#password").value.length > 20) {
        alert('비밀번호는 8자 이상 20자 이하여야 합니다.')
        document.querySelector("#password").focus();
        return;
    }
    if (document.querySelector("#repassword").value != document.querySelector("#password").value) {
        alert('비밀번호 확인이 일치하지 않습니다.')
        document.querySelector("#repassword").focus();
        return;
    } else {
        alert('비밀번호가 일치합니다.');
        document.querySelector("#pcon").value = "일치함";
        document.querySelector("#pcon").disabled = 'disabled';
        document.querySelector("#repassword").disabled = 'disabled';
        document.querySelector("#password").disabled = 'disabled';
        document.querySelector("#tel").focus();
        pcon = true;
    }
}

function selkind(kind) {
    document.querySelector("#searchbtn").innerText = kind;
}

function search() {
    kind = document.querySelector("#searchbtn").innerText;
    svalue = document.querySelector("#search").value;
    location.href = "searchList.jsp?kind=" + kind + "&search=" + svalue;
}