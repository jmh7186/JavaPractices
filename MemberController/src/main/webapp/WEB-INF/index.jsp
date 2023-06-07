<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>
	<script src="https://kit.fontawesome.com/d210744c0d.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
	
	<!-- jQuery 코드와 JavaScript 코드가 혼용되어 있을 경우 둘 다 로드하면
	문제가 발생할 수 있으므로 각각 파일을 나누기를 권장 -->
	<script>
		<%if(request.getParameter("page")!=null) {
			%>pageChange('main','<%=request.getParameter("page")%>');<%
		}
		%>
	</script>
</head>

<body>
	<header><%@ include file="/WEB-INF/home/header.jsp"%></header>
	<div id="middle">
		<aside><jsp:include page="/WEB-INF/${asidepage}" /></aside>
		<main><jsp:include page="/WEB-INF/${mainpage}" /></main>
	</div>
	<footer><%@ include file="/WEB-INF/home/footer.jsp"%></footer>
</body>
<style>
* {
	margin: 0;
	padding: 0;
}

a>i {
	color: white;
}

h1 {
	font-weight: bolder;
}

/* nav */
.navbar {
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: space-between;
	background-color: #263343;
	color: white;
	width: 100%;
	height: 68px;
	position: fixed;
	top: 0;
}

.navbar_menu, .navbar_icon {
	list-style-type: none;
	display: flex;
}

.navbar_icon {
	margin: 0;
	margin-right: 50px;
}

.navbar_menu>li {
	border: 1px solid tan;
	border-radius: 5px;
	margin-top: 10px;
	font-size: 20px;
	text-align: center;
	margin-right: 20px;
	padding: 5px;
}
.navbar_logo {
	margin-left: 20px;
}
.navbar_logo>i {
	font-size: 35px;
	margin: 10px;
	color: tan;
}

.navbar_icon>li {
	margin-right: 5px;
	padding-right: 10px;
	padding-left: 10px;
	font-size: 20px;
	line-height: 60px;
}

.navbar_menu>li:hover, .navbar_icon>li:hover {
	background-color: tan;
}

@media screen and (max-width: 900px) {
	.navbar_toogleBtn {
		display: block;
	}
	.navbar_menu {
		display: none;
	}
	.navbar_icon {
		display: none;
	}
}

@media screen and (min-width: 899px) {
	.navbar_toogleBtn {
		display: none;
	}
	.navbar_icon {
		visibility: visible;
	}
}

.navbar_toogleBtn {
	position: absolute;
	top: 7px;
	right: 50px;
	font-size: 30px;
}

/* main */
#middle {
	width: 100%;
	height: 700px;
	display: flex;
	margin-top: 68px;
	white-space: nowrap;
}

#middle>main {
	width: 100%;
	height: 700px;
	background-color: bisque;
}

/* aside */
#middle>aside {
	width: 400px;
	height: 700px;
	background-color: beige;
	min-width: 200px;
}

#middle>aside>ul {
	list-style-type: none;
	text-align: center;
	line-height: 40px;
	margin-top: 10px;
	font-size: 25px;
}

#middle>aside>ul>li {
	margin: 10px;
}

/* footer */
footer {
	width: 100%;
	height: 120px;
	background-color: antiquewhite;
	padding-top: 5px;
}

footer>p {
	display: flex;
	justify-content: center;
	align-items: center;
	line-height: 15px;
	white-space: nowrap;
 	overflow: hidden;
}

/*-------------------------------------------*/
#loginform {
	text-align: center;
	margin-top: 100px;
}

#signupform {
	text-align: center;
	margin-top: 50px;
}

/* �쎄� ���� */
.contract {
	margin: 50px 100px 50px 100px;
	padding: 30px 40px 50px;
	border-radius: 30px;
	background-color: rgb(167, 193, 204);
}

.contract h1 {
	text-align: center;
}

.contract .text {
	height: 230px;
	border: 1px solid black;
	background-color: white;
	white-space: pre-line;
	overflow-y: scroll;
	margin: 0 auto 20px;
}

.contract p {
	text-align: right;
}

.contract .box {
	width: 100px;
	height: 40px;
	padding: 8px;
	margin: 0 3px;
}

/* memberValidate.html */
#signup {
	text-align: center;
}
#signup>ul {
	list-style-type: none;
}

#signup>ul>li {
	margin: 10px;
}
</style>
<script>
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
	return false;
}
if (document.getElementById("pwd").value == "") {
	alert('비밀번호 칸이 비어있습니다.');
	document.getElementById("pwd").focus();
	return false;
}
return true;
}

pcon = false;
function confirmpwd() {
if (document.getElementById("pwd").value.length < 8 || document.getElementById("pwd").value.length > 20) {
	alert('비밀번호는 8자 이상 20자 이하여야 합니다.')
	document.getElementById("pwd").focus();
	return;
}
if (document.getElementById("repwd").value != document.getElementById("repwd").value) {
	alert('비밀번호 확인이 일치하지 않습니다.')
	document.getElementById("repwd").focus();
	return;
} else {
	alert('비밀번호가 일치합니다.');
	document.getElementById("pcon").value = "일치함";
	document.getElementById("pcon").disabled = 'disabled';
	document.getElementById("repwd").disabled = 'disabled';
	document.getElementById("pwd").readOnly = true;
	document.getElementById("hp").focus();
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
if (document.getElementById("pwd").value == "") {
	alert('비밀번호 칸이 비어있습니다.')
	document.getElementById("pwd").focus();
	return false;
}
if (document.getElementById("hp").value == "") {
	alert('전화번호 칸이 비어있습니다.')
	document.getElementById("hp").focus();
	return false;
}
if (!(pcon)) {
	alert('비밀번호 검증을 하지 않았습니다.')
	document.getElementById("repwd").focus();
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
</script>
</html>