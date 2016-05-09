<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<a href="${ pageContext.request.contextPath }">마이 홈</a>&nbsp;&nbsp;&nbsp;
 	<a href="${ pageContext.request.contextPath }/board/list.do">게시판</a>&nbsp;&nbsp;&nbsp; 
	<a href='${ pageContext.request.contextPath }/member/memberList.do'>회원관리</a>&nbsp;&nbsp;&nbsp;
</header>