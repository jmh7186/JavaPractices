<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function pageChange(page,path) {
            xhttp = new XMLHttpRequest();
            xhttp.open('get',path);
            xhttp.send();
            xhttp.onreadystatechange = function () {
                document.querySelector(page).innerHTML=this.responseText;
            }
        }
	    function signupValidate() {
		    if (document.getElementById("name").value=="") {
			    alert('성함을 입력해 주세요.');
			    document.getElementById("name").focus();
			    return false;
		    }
            if (document.getElementById("hp").value=="") {
			    alert('전화번호를 입력해 주세요.');
			    document.getElementById("hp").focus();
			    return false;
		    }
            if (document.getElementById("adr").value=="") {
			    alert('주소를 입력해 주세요.');
			    document.getElementById("adr").focus();
			    return false;
		    }
            if (document.getElementById("rank").value=="") {
			    alert('등급을 입력해 주세요.');
			    document.getElementById("rank").focus();
			    return false;
		    }
            if (document.getElementById("city").value=="") {
			    alert('도시코드를 입력해 주세요.');
			    document.getElementById("city").focus();
			    return false;
		    }
            var reg = /^[A-C]?$/;
            rank = document.getElementById("rank").value;
            if ((!reg.test(rank))) {
			    alert('올바른 등급을 입력해 주세요.');
			    document.getElementById("rank").focus();
			    return false;
		    }
            reg = /^[0-9]{1,2}$/;
            city = document.getElementById("city").value;
            if (!(reg.test(city))) {
			    alert('도시코드는 한 자리 또는 두 자리 숫자입니다.');
			    document.getElementById("city").focus();
			    return false;
		    }
		    return true;
	    }
    </script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        
		body {
			min-width: 820px;
		}
		
        header {
            text-align: center;
            height: 100px;
            line-height: 100px;
            background-color: blue;
            font-size: 30px;
            color: white;
        }

        nav {
            background-color: rgb(210, 176, 243);
            color: white;
        }

        nav>ul>li {
            display: inline;
            padding: 15px;
            line-height: 50px;
        }
        nav>ul>li:hover {
            background-color: rgb(189, 133, 245);
        }

        #middle>section {
            height: 580px;
            background-color: gainsboro;
            padding: 20px;
        }

        #middle h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        footer {
            text-align: center;
            height: 80px;
            line-height: 80px;
            background-color: rgb(70, 70, 255);
            color: white;
        }
    </style>
</head>

<body>
    <div id="top">
        <header>쇼핑몰 회원관리 ver 1.0</header>
        <nav>
            <ul>
                <li onclick="pageChange('section','/signup')">회원등록</li>
                <li onclick="pageChange('section','/list')">회원목록조회/수정</li>
                <li onclick="pageChange('section','/moneylist')">회원매출조회</li>
                <li onclick="location.href='/'">홈으로.</li>
            </ul>
        </nav>
    </div>
    <div id="middle">
        <section>
            <h2>쇼핑몰 회원관리 프로그램</h2>
            <p>쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.</p>
            <p>프로그램 작성 순서</p>
            <p>1.회원정보 테이블을 생성한다.</p>
            <p>2.매출정보 테이블을 생성한다.</p>
            <p>3.회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</p>
            <p>4.회원정보 입력 화면프로그램을 작성한다.</p>
            <p>5.회원정보 조회 프로그램을 작성한다</p>
            <p>6.회원매출정보 조회 프로그램을 작성한다.</p>
        </section>
    </div>
    <footer>HRDKOREA Copyrightⓒ2016 All rights reserved. Human Resources Development Service of Korea.</footer>
</body>

</html>