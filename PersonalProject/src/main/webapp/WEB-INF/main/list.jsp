<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("id") != null) {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	
	int totalCount=0; //전체게시물 수 
	int countPerPage=10; //페이지당 글의 수
	int totalPage=0; //전체페이지 수
	int startPage=0; //시작페이지
	int endPage=0; //끝페이지

	//전체게시물 수
	PreparedStatement ps=conn.prepareStatement("select count(*) from phonebook");
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		totalCount=rs.getInt("count(*)");
	}

	//예)전체게시물수 80 or 86
	// 80/10=8page, 86/10=9page
	if(totalCount%countPerPage==0){
		totalPage=totalCount/countPerPage;	
	}else{
		totalPage=(totalCount/countPerPage)+1;
	}

	//현재페이지 의한 navigate를 구하는 방법
	int currentPage=1;  //현재페이지
	if(request.getParameter("page")!=null && !(request.getParameter("page").equals(""))) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}
	 
	/* if((currentPage/5)<2){
		startPage=1;
		endPage=startPage+4;
		// 6~9페이지여도 위 코드가 실행되므로 5로 나누어 떨어지지 않는 나머지의 경우는 아래 코드 실행
		if((currentPage%5)!=0){
			startPage=(currentPage/5)*5+1;
			endPage=startPage+4;
		}
	}else{
		//10페이지부터 페이지 처리
		startPage=(currentPage/5)*5+1;
		endPage=startPage+4;
		
	} */
	
	if ( currentPage/10<1 ) {
		startPage=1;
		endPage=10;
	}else {
		startPage=currentPage-(currentPage%10);
		endPage=startPage+10;
	}
	
	//전체페이지수보다 endPage가 클때 endPage는 전체페이지의 값이 된다.
	if(endPage>totalPage){
		endPage=totalPage;
	}
	
	int startRow=(currentPage-1)*countPerPage+1; //글의 시작번호
	int endRow=currentPage*countPerPage; //글의 끝번호
	ps = conn.prepareStatement("select * from (phonebook_rownum) where num>=? and num<=?");
	ps.setInt(1, startRow);
	ps.setInt(2, endRow);
	rs = ps.executeQuery();
%>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
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
						String idx = rs.getString("num");
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
					%>
				</tbody>
			</table>
			<div class="container mt-3">
				<ul class="pagination">
					<%
					if (startPage > 5) {
					%>
					<li class="page-item"><a class="page-link"
						href="/phonebook?page=<%=startPage-1%>">Previous</a></li>
					<%}%>

					<%
					for (int i = startPage; i <= endPage; i++) {
						if(currentPage==i) {
							%>
							<li class="page-item active"><a class="page-link" href="/phonebook?page=<%=i%>"><%=i%></a></li>
							<%
						}else {
							%>
							<li class="page-item"><a class="page-link" href="/phonebook?page=<%=i%>"><%=i%></a></li>
							<%
						}
					}
					if (endPage != totalPage) { //endPage<startPage+4
					%>
					<li class="page-item"><a class="page-link"
						href="/phonebook?page=<%=endPage%>">Next</a></li>
					<%}
					rs.close();
					ps.close();
					conn.close();%>
				</ul>
			</div>
		</div>
		<button onclick="location.href='/phonebook/insert.jsp'"
			class="btn btn-warning">전화번호 추가</button>
	</div>
</body>
<script>
	function page(i) {
		location.href='/phonebook?page='+i;
	}
</script>
<%
} else {
%>
<script>
	alert('로그인 후 이용 가능합니다.');
</script>
<%}
%>