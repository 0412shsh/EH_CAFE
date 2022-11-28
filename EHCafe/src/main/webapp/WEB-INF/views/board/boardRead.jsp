<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">🎂insertBoard - 게시글 내용보기 🎂</h1>

<!-- 게시글 헤더  -->
	카테고리 : ${vo.category }
	제목 : ${vo.title } 
	작성자 : ${vo.user_name }
	작성시간 : 
	<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }" />
<!-- 게시글 헤더  -->

<!-- 게시글 본문 -->
	${vo.content }
<!-- 게시글 본문 -->

<!-- 게시글 버튼 -->
<button type="button" onclick="location.href='/board/listAll'">목록</button>
<button type="button" onclick="location.href='/board/update'">수정</button>
<button type="button" onclick="location.href='/board/delete'">삭제</button>
<!-- 게시글 버튼 -->

