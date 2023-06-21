<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<div id="inputs">
    	<input type="text" id="id" onkeyup='submitkey(event)'>
    	<input type="password" id="password" onkeyup='submitkey(event)'>
    	<button onclick="submit()">로그인</button>
    </div>
    <hr>	
    <textarea id="chatbox" style="width: 300px; height:500px;" readonly></textarea>
</body>
<script>
	const ws = new WebSocket("ws://localhost:8080/chatuser");
	var user;
	ws.onopen = function (msg) {
		console.log('open');
		user = new Object();
	}
	
	ws.onclose = function (msg) {
		console.log('close');
	}
	
	ws.onerror = function (msg) {
		console.log('error');
	}
	
	ws.onmessage = function (msg) {
		const json = JSON.parse(msg.data);
		kind = json.kind;
		result = json.result;
		if(kind == "login") {
			if(result=='success') {
				document.querySelector('#chatbox').value+=json.id+" 님 로그인 성공!\r\n";
				document.querySelector('#inputs').innerHTML="<input type='text' id='chat' onkeyup='sendkey(event)'><button onclick='sendmsg()'>전송</button><input type='text' id='sel'><button onclick='selmsg()'>귓속말 지정 전송</button>"
				user.id=json.id;
			}else {
				document.querySelector('#chatbox').value+="로그인 실패\r\n";
			}
		}else if(kind == "chat") {
			document.querySelector('#chatbox').value+=json.id+" : "+json.msg+"\r\n";
		}else if(kind=="sel") {
			document.querySelector('#chatbox').value+="(귓속말)"+json.id+" : "+json.msg+"\r\n";
		}
	}
	function submit() {
		user.kind = "login";
		user.id = document.getElementById('id').value;
		user.password = document.getElementById('password').value
		ws.send(JSON.stringify(user));
		document.getElementById('id').value="";
		document.getElementById('password').value="";
		user.password="";
	}
	function sendmsg() {
		user.kind = "chat";
		user.msg=document.getElementById('chat').value;
		ws.send(JSON.stringify(user));
		document.getElementById('chat').value="";
		document.getElementById('chat').focus();
	}
	function sendkey(event) {
		if(event.keyCode==13) {
			sendmsg();
		}
	}
	
	function submitkey(event) {
		if(event.keyCode==13) {
			submit();
		}
	}
	function selmsg () {
		user.kind = "sel";
		user.selid = document.getElementById('sel').value;
		user.msg = document.getElementById('chat').value;
		ws.send(JSON.stringify(user));
		document.getElementById('chat').value="";
		document.getElementById('chat').focus();
	}
</script>
</html>