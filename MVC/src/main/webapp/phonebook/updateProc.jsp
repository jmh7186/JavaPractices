<%@page import="phonebook.PhonebookDAO"%>
<%@page import="phonebook.PhonebookVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String idx = request.getParameter("idx");
String newname = request.getParameter("name");
String newhp = request.getParameter("hp");
String newcompany = request.getParameter("company");
String newemail = request.getParameter("email");
String newaddress = request.getParameter("address");
String newbirthday = request.getParameter("birthday");
String newmemo = request.getParameter("memo");

PhonebookVO p = new PhonebookVO(idx,newname,newhp,newcompany,newemail,newaddress,newbirthday,newmemo);

	switch (new PhonebookDAO().update(idx, p)) {
	case 1:
		%>
		<script>
			alert('전화번호가 수정되었습니다.');
			location.href="view.jsp?idx=<%=idx%>";
		</script>
		<%
		break;
	case 2:
	%>
	<script>
		alert('기존 전화번호를 찾지 못했습니다. 다시 시도해주세요.');
		history.back();
	</script>
	<%
		break;
	default:
		%>
		<script>
			alert('오류가 발생하여 수정하지 못했습니다.');
			history.back();
		</script>
		<%
		break;
	}
%>