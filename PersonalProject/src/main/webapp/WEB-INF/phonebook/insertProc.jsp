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

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
PreparedStatement pstat = conn.prepareStatement("insert into phonebook values(PHONEBOOK_IDX_SEQ.nextval,?,?,?,?,?,?,?)");
pstat.setString(1, name);
pstat.setString(2, hp);
if(company.equals("")) company=null;
pstat.setString(3, company);
if(email.equals("")) email=null;
pstat.setString(4, email);
if(address.equals("")) address=null;
pstat.setString(5, address);
if(birthday.equals("")) birthday=null;
pstat.setString(6, birthday);
if(memo.equals("")) memo=null;
pstat.setString(7, memo);
if (pstat.executeUpdate()>0) {
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
pstat.close();
conn.close();
%>