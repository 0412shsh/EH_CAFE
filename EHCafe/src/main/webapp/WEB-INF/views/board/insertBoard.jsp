<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">🎂insertBoard - 게시글 작성 🎂</h1>

<!-- 폼 시작 -->
<form action="/board/insertBoard" method="post" >

<!-- 말머리 선택 -->
말머리 
<select name="category">
	<option> -- 말머리 선택 -- </option>
	<option value="예약">예약</option>
	<option value="환불">환불</option>
	<option value="제휴">제휴</option>
	<option value="기타">기타</option>
</select>

<!-- 작성자명 -->
작성자
<input type="text" value="${loginVO.user_name}" readonly="readonly" id="user_name">
<input type="hidden" name="user_id" value="${loginVO.user_id}"> 
<input type="hidden" name="user_name" value="${loginVO.user_name}">                 


<!-- 제목 -->
제목
<input type="text" name="title" placeholder="제목을 작성하세요."><br>
<!-- <input type="text" value="문의합니다💖💖" name="title" placeholder="제목을 작성하세요." readonly="readonly" ><br> -->

<!-- 내용 -->
내용
<textarea name="content" cols="100" rows="20" placeholder="내용을 작성하세요."></textarea>

<!-- 게시글 제어 버튼 -->
<button type="submit">등록</button>
<button type="button" onclick="location.href='#'">취소</button>

</form>