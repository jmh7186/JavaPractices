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
<body onkeyup="clearmsg(event)">
	<button onclick="sendmessage('Hello')">고정 메시지 전송</button>
	<hr>
	<input type="text" id="text">
	<input type="button" id="sendbtn" onclick="sendvarmessage()"
		value="가변 메시지 전송"><br>
	<textarea style="width: 200px; height: 400px;" id="chat" readonly></textarea><br>
	<input type="button" id="clearbtn" onclick="document.getElementById('chat').value = ''"
		value="채팅기록 지우기 (End)">
</body>
<script>
	/* 웹소켓 생성 (주소 필요) */
	var ws = new WebSocket("ws://192.168.0.53:8080/ws");
	/* 이벤트를 통해 데이터 송수신 */
	ws.onopen = function(msg) {
		console.log('Open');
	}
	ws.onclose = function(msg) {
		console.log('Close');
	}
	ws.onerror = function(msg) {
		console.log('Error');
	}
	ws.onmessage = function(msg) {
		document.getElementById("chat").value+=msg.data+'\r\n';
	}

	function sendmessage() {
		ws.send('Hello');
	}

	function sendvarmessage() {
		var msg = document.getElementById("text").value;
		ws.send(msg);
		document.getElementById("text").value = "";
		document.getElementById("text").focus();
	}

	document.getElementById("text").addEventListener("keyup", function(event) {
		if (event.keyCode == 13) {
			sendvarmessage();
		}
	});
	
	function clearmsg(e) {
		if (e.keyCode == 35) {
			document.getElementById("chat").value = "";
		}
	}
</script>
</html>