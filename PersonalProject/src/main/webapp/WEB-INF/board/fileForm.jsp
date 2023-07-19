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
    <form action="/fileProc" method="post" enctype="multipart/form-data">
    	IDX : <input type="text" id="idx" name="idx"><br>
    	File : <input type="file" id="file" name="file"><br>
    	<input type="submit" value="전송">
    </form>
</body>
</html>