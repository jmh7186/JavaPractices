<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDAO mdao;
MemberVO mvo;
String keyword = request.getParameter("keyword");
if(keyword==null || keyword.equals("")){
	mdao = new MemberDAO();
	%>
	<table border="1">
  	<tr>
    	<th>아이디</th>
    	<th>비밀번호</th>
    	<th>연락처</th>
    	<th>주소</th>
  	</tr>
	<%
	for (int i=0; i<mdao.findAll().size();i++) {
	%>
  	<tr>
    	<td><%=mdao.findAll().get(i).getId()%></td>
    	<td><%=mdao.findAll().get(i).getPwd()%></td>
    	<td><%=mdao.findAll().get(i).getHp()%></td>
    	<td><%=mdao.findAll().get(i).getAdr()%></td>
  	</tr>
	<%
	}
	%>
	</table>
	<button onclick="history.back()">돌아가기</button>
	<%
}else if ((mvo = new MemberDAO().findById(keyword))!=null) {
	%>
	<table border="1">
  	<tr>
   	 	<th>아이디</th>
    	<th>비밀번호</th>
    	<th>연락처</th>
    	<th>주소</th>
  	</tr>
  	<tr>
    	<td><%=mvo.getId()%></td>
    	<td><%=mvo.getPwd()%></td>
    	<td><%=mvo.getHp()%></td>
    	<td><%=mvo.getAdr()%></td>
  	</tr>
	</table>
	<button onclick="history.back()">돌아가기</button>
	<%
}else if((mvo = new MemberDAO().findById(keyword))==null){
	%>
	<script>
		alert('일치하는 아이디가 없습니다.');
		history.back();
	</script>
	<%
}else{
	%>
	<script>
		alert('오류가 발생했습니다.');
		history.back();
	</script>
	<%
}
%>