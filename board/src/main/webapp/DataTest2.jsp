<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	//문자열
	var str = "Hello";
	//문자열 배열
	var arr = ["H","e","l","l","o"];
	//객체
	var obj = {
				str1:"H",
				str2:"e",
				str3:"l",
				str4:"l",
				str5:"o",
				};
	
	//접근 방법
/* 	console.log(str);
	console.log(arr[0]);
	console.log(obj.str1);
	console.log(obj["str1"]); */
	//네트워크 상 데이터 전송 형식
	//문자열 >> 문자열로 전송됨
	//배열 >> 문자열로 변환 필요
	console.log(arr.join(''));
	console.log(JSON.stringify(arr)); //["H","e","l","l","o"]
	//객체 >> 문자열로 변환 필요
	//JSON.parse();
	//데이터 수신 형식
	//문자열 >> 배열
	str = "Hello";
	arr=str.split('');
	
	for(i=0;i<arr.length;i++) {
		console.log(arr[i]);
	}
	
	for(i in arr) {
		console.log(arr[i]);
	}
	
	arr.forEach(function (item,i) { //index 번호와 값을 같이 반환
		console.log(i+':'+item);
	});
	
	arr.forEach((item,i) => console.log(i+':'+item)); //람다식

	str="java";
	arr=Array.from(str);
	console.log(arr.toString());
	
	//문자열 >> 객체
	//오브젝트와 JSON을 혼동하지 말 것, json은 문자열이다.
	obj = {name:"HongGilDong", age:30};
	json = '{"name":"HongGilDong","age":"30"}';
	obj = JSON.parse(json);
	console.log(obj.name+" / "+obj.age);
	obj = {name:"HongGilDong", age:30};
	obj = JSON.stringify(obj);
	console.log(JSON.parse(obj).name);
	</script>