<%@page import="member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//스크립트릿 영역(이 밖은 HTML영역)
//JSP페이지에는 기본 객체가 존재한다. (request, response)
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String hp = request.getParameter("hp");
String adr = request.getParameter("adr");

/* 물리 테이블 작성
create table member(
mid varchar2(10) primary key,
mpwd varchar2(20) not null,
mhp varchar2(13) not null,
madr varchar2(200)
);
입력받은 내용을 데이터베이스에 추가 */


MemberDAO mdao = new MemberDAO();

switch (mdao.insert(id, pwd, hp, adr)) {
case 1:
	%>
	<script>
		alert('회원가입이 완료되었습니다.');
		location.href='index.html';
	</script>
	<%
break;
case 2:
%>
	<script>
		alert('필수 입력 항목이 빠졌습니다.');
		history.back();
	</script>
<%
break;
case 4:
%>
	<script>
		alert('아이디가 중복됩니다.');
		history.back();
	</script>
<%
break;
default :
%>
	<script>
		alert('오류가 발생했습니다.');
		history.back();
	</script>
<%
	}
%>