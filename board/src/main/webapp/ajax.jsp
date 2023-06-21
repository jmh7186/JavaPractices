<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<div>
</div>
<script>
	$.ajax({
		url:"curl.jsp",
		success : data => {
			const json = JSON.parse(data);
			$("div").text(json.name+' / '+json.age);
			console.log(JSON.stringify(json));
		}
	});
</script>