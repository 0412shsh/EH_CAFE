<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">🎂boardRead - 게시글 내용보기 🎂</h1>

<!-- 게시글 헤더  -->
	카테고리 : ${vo.category }<br>
	제목 : ${vo.title } <br>
	작성자 : ${vo.user_name }<br>
	작성시간 : 
	<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }" />
<!-- 게시글 헤더  -->

<!-- 게시글 본문 -->
	${vo.content }
<!-- 게시글 본문 -->

<!-- 게시글 버튼 -->
<button type="button" onclick="location.href='/board/listAll2'">목록</button>
<button type="button" onclick="location.href='/board/modify?board_num='+'${vo.board_num}'">수정</button>
<button type="button" onclick="location.href='/board/delete?board_num='+'${vo.board_num}'">삭제</button>
<!-- 게시글 버튼 -->

