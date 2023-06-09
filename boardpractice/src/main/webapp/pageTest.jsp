<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
out.write("<meta charset='UTF-8'>");
int totalCount=0; //전체 항목 수
int countPerPage=10; //페이지 당 항목 수
int totalPage=0; // 총 페이지 수
int startPage=0; // 시작 페이지
int endPage=0; // 끝 페이지

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
PreparedStatement ps = conn.prepareStatement("select count(*) from phonebook");
ResultSet rs = ps.executeQuery();
if(rs.next()) {
	totalCount = rs.getInt("count(*)");
}
if(totalCount%countPerPage==0) {
	totalPage=totalCount/countPerPage;
}else {
	totalPage=(totalCount/countPerPage)+1;
}

int currentPage=6; // 현재 페이지
startPage=((currentPage-1)/countPerPage)*countPerPage+1;
endPage=startPage+currentPage-1;
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
currentPage=7;
int startRow=(currentPage-1)*countPerPage+1; //글의 시작번호
int endRow=currentPage*countPerPage; //글의 끝번호
ps = conn.prepareStatement("select * from (phonebook_rownum) where num>=? and num<=?");
ps.setInt(1,startRow);
ps.setInt(2,endRow);
rs=ps.executeQuery();
%>
<div class="container mt-3">
  <table class="table">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>회사</th>
        <th>이메일</th>
        <th>주소</th>
        <th>생일</th>
        <th>메모</th>
      </tr>
    </thead>
    <tbody>
    <%while(rs.next()) {%>
      <tr>
        <td><%=rs.getInt("num")%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("hp")%></td>
        <td><%=rs.getString("company")%></td>
        <td><%=rs.getString("email")%></td>
        <td><%=rs.getString("address")%></td>
        <td><%=rs.getString("birthday").replaceAll(" 00:00:00", "")%></td>
        <td><%=rs.getString("memo")%></td>
      </tr>
     <%}%>
    </tbody>
  </table>
</div>
<div class="container mt-3">    
  <ul class="pagination justify-contents-center">
  <%if(startPage>5){%>
    <li class="page-item"><a class="page-link" href="pageTest?currentPage=">Previous</a></li>
  <%}%>  
    
    <%for(int i=startPage;i<=endPage;i++){ %>
    <li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
    <%} %>
    
    <%if(endPage!=totalPage){ //endPage<startPage+4%>
    <li class="page-item"><a class="page-link" href="pageTest?currentPage=">Next</a></li>
    <%}%>
  </ul>
</div>
</body>
</html>
