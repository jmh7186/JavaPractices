<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if(session.getAttribute("id")!=null) {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
PreparedStatement pstat = conn.prepareStatement("select * from phonebook");
ResultSet rs = pstat.executeQuery();
%>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
	<div class="container mt3">
		<h1>전화번호부</h1>
		<div class="input-group mt-3 mb-3">
			<button id="searchbtn" type="button"
				class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
				id="selbtn" name="selbtn">검색 선택</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" onclick="selkind('이름')">이름</a></li>
				<li><a class="dropdown-item" onclick="selkind('전화번호')">전화번호</a></li>
				<li><a class="dropdown-item" onclick="selkind('직장')">직장</a></li>
				<li><a class="dropdown-item" onclick="selkind('전체검색')">전체검색</a></li>
			</ul>
			<input id="search" type="text" class="form-control" id="search"
				placeholder="검색..." name="search">
			<button onclick="search()" type="button" class="btn btn-info"
				id="searchbtn" name="searchbtn">검색</button>
		</div>
		<div class="container mt-3">
			<table class="table">
				<thead class="table-light">
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>직장</th>
						<th>이메일</th>
						<th>주소</th>
						<th>생일</th>
						<th>메모</th>
					</tr>
				</thead>
				<tbody>
					<%
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					while (rs.next()) {
						String idx = rs.getString("idx");
						String name = rs.getString("name");
						String hp = rs.getString("hp");
						String company = rs.getString("company");
						if (company == null)
							company = "-";
						String email = rs.getString("email");
						if (email == null)
							email = "-";
						String birthday = "-";
						if (rs.getString("birthday") != null) {
							Date _birthday = formatter.parse(rs.getString("birthday"));
							birthday = formatter.format(_birthday);
						}
						String address = rs.getString("address");
						if (address == null)
							address = "-";
						String memo = rs.getString("memo");
						if (memo == null)
							memo = "-";
					%>
					<tr>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=idx%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=name%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=hp%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=company%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=email%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=address%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=birthday%></td>
						<td onclick="location.href='/phonebook/view.jsp?idx=<%=idx%>'"><%=memo%></td>
					</tr>
					<%
					}
					rs.close();
					pstat.close();
					conn.close();
					%>
				</tbody>
			</table>
		</div>
		<button onclick="location.href='/phonebook/insert.jsp'"
			class="btn btn-warning">전화번호 추가</button>
	</div>
</body>
<%}else {%>
	<script>
		alert('로그인 후 이용 가능합니다.');
	</script>
<%}%>