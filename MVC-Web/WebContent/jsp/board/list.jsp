<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		if("${msg}") {
			alert("${ msg }");
		} 
	}
</script>
</head>
<body>
	<c:import url="/jsp/include/topMenu.jsp"/>
	
	<table border="1" width="70%">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${ list }">
			<tr>
				<td>${ board.no }</td>
				<td><c:out value="${ board.title }"/></td>
				<td><c:out value="${ board.writer }" /></td>
				<td>${ board.regDate }</td>
			</tr>
		</c:forEach>
		
		<c:if test="${ empty list }">
			<tr>
				<td colspan="4">검색된 게시물이 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</table>
	<a href="${pageContext.request.contextPath }/jsp/board/writeForm.jsp">글쓰기 이동</a>
</body>
</html>