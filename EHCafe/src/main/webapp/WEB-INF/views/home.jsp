<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	${loginVO.user_id}
	${loginVO.user_name}
	
	<button type="button" onclick="location.href='/board/listAll'">문의게시글(관리자)</button>
	<button type="button" onclick="location.href='/board/listAll2'">문의게시글(일반)</button>
	<button type="button" onclick="location.href='/member/login'">로그인</button>
	<button type="button" onclick="location.href='/member/logout'">로그아웃</button>
	
	
	
</body>
</html>
