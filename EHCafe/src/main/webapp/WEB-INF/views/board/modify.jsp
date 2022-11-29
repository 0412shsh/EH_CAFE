<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 카테고리 제어
		$('#form').submit(function(){
			if($('#category option:selected').val()==""){
				alert("카테고리를 선택해주세요.");
				$('#category').focus();
				return false;
			}
		// 제목 제어
			if($('#title').val()==""){
				alert("제목을 작성하세요.")
				$('#title').focus();
				return false;
			}
		
		
		// 내용 제어	
			if($('#content').val()==""){
				alert('내용을 작성하세요.');
				$('#content').focus();
				return false;
			}
		
		});
	});
	
	

	
	</script>




<h1 style="background-color:#E4FFF5">🎂modify - 게시글 수정 🎂</h1>



<!-- 폼 시작 -->
<form action="/board/modify" method="post" id="form" >
<input type="hidden" name="board_num" value="${vo.board_num }">

<!-- 말머리 선택 -->
말머리 
<select name="category" id="category" >
<!-- 	<option value=""> -- 말머리 선택 -- </option> -->
	<option value="${vo.category }" >${vo.category }</option>
</select>

<!-- 작성자명 -->
작성자
<input type="text" value="${loginVO.user_name}" readonly="readonly" id="user_name">
<input type="hidden" name="user_id" value="${loginVO.user_id}"> 
<input type="hidden" name="user_name" value="${loginVO.user_name}">   
             


<!-- 제목 -->
제목
<input type="text" id="title" name="title" value="${vo.title}" ><br>
<!-- <input type="text" value="문의합니다💖💖" name="title" placeholder="제목을 작성하세요." readonly="readonly" ><br> -->

<!-- 내용 -->
내용
<textarea name="content" id="content" cols="100" rows="20" >${vo.content}</textarea>

<!-- 게시글 제어 버튼 -->
<button type="submit">수정</button>
<button type="button" onclick="location.href='/board/listAll2'">취소</button>

</form>