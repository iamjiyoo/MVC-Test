<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/jsp/include/topMenu.jsp" />
	<hr/>
	<h2>게시글 등록</h2>
	<hr/>
	<form method="post" action="${pageContext.request.contextPath }/board/write.do">
		제목 : <input type="text" name="title" size="70" /><br/>
		글쓴이 : <input type="text" name="writer" size="30" /><br/>
		내용 : <textarea rows="7" cols="70" name="content"></textarea>
		<input type="submit" value="등록" />
	</form>
</body>
</html>