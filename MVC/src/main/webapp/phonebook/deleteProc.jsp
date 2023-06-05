<%@page import="phonebook.PhonebookDAO"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (new PhonebookDAO().delete(request.getParameter("idx"))>0) {
	%>
	<script>
		alert('전화번호가 삭제되었습니다.');
		location.href="list.jsp";
	</script>
	<%
}else{
	%>
	<script>
		alert('오류가 발생하여 삭제하지 못했습니다.');
		history.back();
	</script>
	<%
}
%>