<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>

	
	

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


<!-- 게시글 댓글 -->
<div>
	<ol>
		<c:forEach items="${commentList }" var="commentList">
			<li>
				<p>
				작성자 : ${commentList.user_id }<br>
				작성날짜 : <fmt:formatDate value="${commentList.reply_date }" pattern="yyyy-mm-dd" />
				</p>
				<p>${commentList.comment }</p>
			</li>		
		</c:forEach>
	</ol>
</div>

<!-- 게시글 댓글 -->

<!-- 게시글 댓글 작성 -->
<form action="/board/insertComment" method="post" >
	<input type="hidden" name="board_num" value="${vo.board_num }">
	
	<div>
		<label>댓글작성자</label><input type="text" value="${loginVO.user_name }" readonly="readonly">
		<input type="hidden" name="user_id" value="${loginVO.user_id}"> 
		<input type="hidden" name="user_name" value="${loginVO.user_name}"> 
		<br>
		<label>댓글 내용</label><input type="text" id="comment" name="comment">
	</div>
	<div>
		<button type="submit">작성하기</button>
	</div>
</form>

<!-- 게시글 댓글 작성 -->

  



<!-- 게시글 버튼 -->
<button type="button" onclick="location.href='/board/listPage'">목록</button>
<button type="button" onclick="location.href='/board/modify?board_num='+'${vo.board_num}'">수정</button>
<button type="button" onclick="location.href='/board/delete?board_num='+'${vo.board_num}'">삭제</button>
<!-- 게시글 버튼 -->

