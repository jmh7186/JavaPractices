<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
ul {
	list-style: none;
}

li {
	display: inline-block;
	padding: 20px;
	margin-left: 30px;
}

button {
	width: 50px;
	font-size: 20px;
}
</style>
</head>
<body>
	<ul>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
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
		data = msg.data.replace('[','').replace(']','').split(',');
		for(i=0;i<data.length;i++) {
			document.querySelector('li:nth-child('+(i+1)+')').innerHTML='<h1>'+data[i]+'</h1><button onclick="vote('+(i+1)+')">'+(i+1)+'</button>';
		}
	}
	
	function vote(i) {
		ws.send(i);
	}
</script>
</html>