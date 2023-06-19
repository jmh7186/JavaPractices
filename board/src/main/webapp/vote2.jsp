<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <div>
        	<input type="text" id="msg"><button onclick="sendmsg()">전송</button><br>
        </div>
    </body>
    <script>
        var ws = new WebSocket("ws://192.168.0.53:8080/test");
        ws.onopen = function (msg) {
            console.log('Open');
        }
        ws.onclose = function (msg) {
            console.log('Close');
        }
        ws.onerror = function (msg) {
            console.log('Error');
        }
        ws.onmessage = function (msg) {
        	console.log(msg);
        	document.querySelector('div').innerHTML += msg.data+"<br>"
        }
        function sendmsg() {
        	ws.send(document.getElementById("msg").value);
        	document.getElementById("msg").value="";
        	document.getElementById("msg").focus();
        }
        document.getElementById("msg").addEventListener("keyup", function (e) {
        	if(e.keyCode==13) {
        		sendmsg();
        	}
        });
    </script>

    </html>