<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int idx = Integer.valueOf(request.getParameter("idx"));
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
PreparedStatement pstat = conn.prepareStatement("delete phonebook where idx=?");
pstat.setInt(1, idx);
if (pstat.executeUpdate()>0) {
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
pstat.close();
conn.close();
%>