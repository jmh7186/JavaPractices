<%@page import="phonebookmvc1.dao.PhonebookDAO"%>
<%@page import="phonebookmvc1.vo.PhonebookVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String name = request.getParameter("name");
String hp = request.getParameter("hp");
String company = request.getParameter("company");
String email = request.getParameter("email");
String address = request.getParameter("address");
String birthday = request.getParameter("birthday");
if(birthday!=null && !(birthday.equals(""))) {
	Date _birthday = formatter.parse(request.getParameter("birthday"));
	birthday = formatter.format(_birthday);
}
String memo = request.getParameter("memo");

PhonebookVO p = new PhonebookVO("0",name,hp,company,email,birthday,address,memo);

if (new PhonebookDAO().insert(p)>0) {
	%>
	<script>
		alert('전화번호가 입력되었습니다.');
		location.href="list.jsp";
	</script>
	<%
}else{
	%>
	<script>
		alert('오류가 발생하여 입력하지 못했습니다.');
		history.back();
	</script>
	<%
}
%>