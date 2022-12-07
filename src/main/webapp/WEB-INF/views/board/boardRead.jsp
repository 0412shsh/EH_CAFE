<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">



function updateReplyFun(board_num,reply_num,comment,user_id){
	alert("함수실행 "+ board_num+",,"+reply_num+",,"+comment+",,"+user_id);
		
		 var commentsView = "";
		// var buttonView = "";
	
		 
		commentsView += '<form action="/board/updateReply" method="post" id="boardReply" style="margin-bottom:50px;">';
		commentsView += user_id;
		commentsView += '<input type="hidden" name="board_num" value="'+board_num+'">';
		commentsView += '<textarea class="form-control" name="comment" id="message'+reply_num+'" cols="30" rows="5" placeholder="글내용" style="line-height: 0.8; margin-bottom:20px; margin-top:10px;">';
		commentsView += comment;
		commentsView += '</textarea>';
		commentsView += '<input type="hidden" name="reply_num" value="'+reply_num+'">';
		commentsView += '<div class="portfolio-filter">';
		commentsView += '<input type="submit" class="btn" id="updateReply" value="수정완료">'
		commentsView += '</div>';
	
	
		commentsView += '</form>';
		
		
//		buttonView += '완료'
//		buttonView += '</button>'
	
	$('#edit_div' + reply_num).replaceWith(commentsView);
	//$('#edit_button' + reply_num).replaceWith(buttonView);
	$('#message'+reply_num).focus();
}

$(document).ready(function(){
	// 카테고리 제어
	$('#insertComment').submit(function(){
		if($('#comment').val()==""){
			alert("내용을 입력하세요.");
			$('#category').focus();
			return false;
		}
	});
});
</script>

	

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


<!-- 게시글 댓글 출력 및 수정하기, 삭제하기-->
<div>
	<ol>
		<c:forEach items="${commentList }" var="commentList">
			<li>
				<div class="comment-wrapper " id="edit_div${commentList.reply_num }">	
				<p>
				작성자 : ${commentList.user_id }<br>
				작성날짜 : <fmt:formatDate value="${commentList.reply_date }" pattern="yy-MM-dd HH:mm" />
				</p>
				<p>${commentList.comment }</p>
				</div>
			</li>
			
			<div class="comment_control">
				<c:if test="${loginVO.user_id == commentList.user_id }">
					<a class="active" id="updateFormReply" href="javascript:void(0);"
						onclick="updateReplyFun(${vo.board_num },${commentList.reply_num },'${commentList.comment }','${commentList.user_id }');">수정</a>
														
					<a class="active" id="deleteReply" href="javascript:void(0);"
						onclick="deleteReply(${commentList.reply_num })">삭제</a>
				</c:if>
			</div>
			
		</c:forEach>
	</ol>
</div>




<!-- 게시글 댓글 출력 및 수정하기, 삭제하기-->

<!-- 게시글 댓글 작성 -->
<form id="insertComment" action="/board/insertComment" method="post" >
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





세션 아이디 >> ${loginVO.user_id }<br>
댓글 작성자 아이디 >> ${CommentVO.user_id }<br>






<!-- 게시글 버튼 -->
<button type="button" onclick="location.href='/board/listPage'">목록</button>
<button type="button" onclick="location.href='/board/modify?board_num='+'${vo.board_num}'">수정</button>
<button type="button" onclick="location.href='/board/delete?board_num='+'${vo.board_num}'">삭제</button>
<!-- 게시글 버튼 -->

