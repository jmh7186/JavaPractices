<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<div id="chat">
	<h1>채팅</h1>
	<div id="chatbox">환영합니다.<br></div>
	<br>
	<input type="text" id="chatmsg" placeholder="여기에 입력하세요.">
	<input type="button" id="chatbtn" onclick="sendmsg()" value="전송">
</div>

<script>
	var ws = new WebSocket("ws://localhost:8080/chat");
	ws.onopen = function(msg) {
		console.log('Open');
		ws.send("${sessionScope.id} 님이 입장하셨습니다.");
	}
	ws.onclose = function(msg) {
		console.log('Close');
	}
	ws.onerror = function(msg) {
		console.log('Error');
	}
	ws.onmessage = function(msg) {
		document.getElementById("chatbox").innerHTML += msg.data + '<br>';
	}
	function sendmsg() {
		let msg = document.getElementById("chatmsg").value;
		document.getElementById("chatmsg").value = "";
		ws.send("${sessionScope.id} : "+msg);
	}
</script>