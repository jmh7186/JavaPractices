<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<style>
	input[type="number"]{
		width: 50px;
	}
</style>
</head>
<body>
	<form>
		<input type="number" id="su1" name="su1" max="999">
		<input type="submit" formaction="/add" value="+">
		<input type="submit" formaction="/sub" value="-">
		<input type="submit" formaction="/mux" value="*">
		<input type="submit" formaction="/div" value="/">
		<input type="number" id="su2" name="su2" max="999">
	</form>
	<button onclick="sub()">링크를 통해 뺄셈 결과 보내기</button>
</body>
<script>
	function sub() {
		su1=document.getElementById("su1").value;
		su2=document.getElementById("su2").value;
		alert(su1+"/"+su2);
		location.href=`/sub?su1=\${su1}&su2=\${su2}`;
	}
</script>
</html>