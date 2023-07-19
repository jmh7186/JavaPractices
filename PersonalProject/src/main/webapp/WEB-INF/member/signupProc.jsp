<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="vo.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<%
int result = (int) request.getAttribute("result");
if(result==1) {
	%><script>
		alert('회원가입이 완료되었습니다.');
		location.href='/login';
	</script><%
}else if (result==4) {
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