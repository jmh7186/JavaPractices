<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="member.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>

<%
MemberDAO memdao = new MemberDAO();
if(memdao.insert(member)==1) {
	%><script>
		alert('회원가입이 완료되었습니다.');
		location.href='/login';
	</script><%
}else if (memdao.insert(member)==4) {
	%><script>
		alert('아이디가 중복됩니다.');
		history.back();
	</script><%
}else {
	%><script>
		alert('오류가 발생했습니다.');
		location.href='/';
	</script><%
}
%>