<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
PreparedStatement pstat = conn.prepareStatement("select * from phonebook where idx=?");
int idx = Integer.valueOf(request.getParameter("idx"));
String newname = request.getParameter("name");
String newhp = request.getParameter("hp");
String newemail = request.getParameter("email");
String newcompany = request.getParameter("company");
String newbirthday = request.getParameter("birthday");
if(newbirthday!=null && !(newbirthday.equals(""))){
	Date _birthday = formatter.parse(newbirthday);
	newbirthday = formatter.format(_birthday);
}
String newaddress = request.getParameter("address");
String newmemo = request.getParameter("memo");
pstat.setInt(1, idx);
ResultSet rs = pstat.executeQuery();

if(rs.next()) {
	pstat = conn.prepareStatement("update phonebook set name=?, hp=?, company=?, email=?, birthday=?, address=?, memo=? where idx=?");
	if (newname.equals("") || newname==null) newname = rs.getString("name");
	pstat.setString(1, newname);
	if (newhp.equals("") || newhp==null) newhp = rs.getString("hp");
	pstat.setString(2, newhp);
	if (newcompany.equals("") || newcompany==null) newcompany = rs.getString("company");
	pstat.setString(3, newcompany);
	if (newemail.equals("") || newemail==null) newemail = rs.getString("email");
	pstat.setString(4, newemail);
	if (newbirthday==null && rs.getString("birthday")==null) {
		newbirthday=null;
	}else if(newbirthday==null || newbirthday.equals("")) {
		Date _birthday = formatter.parse(rs.getString("birthday"));
		newbirthday = formatter.format(_birthday);
	}
	pstat.setString(5, newbirthday);
	if (newaddress.equals("") || newaddress==null) newaddress = rs.getString("address");
	pstat.setString(6, newaddress);
	if (newmemo.equals("") || newmemo==null) newmemo = rs.getString("memo");
	pstat.setString(7, newmemo);
	pstat.setInt(8, idx);

	if (pstat.executeUpdate()>0) {
		%>
		<script>
			alert('전화번호가 수정되었습니다.');
			location.href="view.jsp?idx=<%=idx%>";
		</script>
		<%
	}else{
		%>
		<script>
			alert('오류가 발생하여 수정하지 못했습니다.');
			history.back();
		</script>
		<%
	}
}else {
	%>
	<script>
		alert('기존 전화번호를 찾지 못했습니다. 다시 시도해주세요.');
		history.back();
	</script>
	<%
}
rs.close();
pstat.close();
conn.close();
%>