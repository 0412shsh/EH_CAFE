<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

 <%
	//관리자가 아닐 경우 접근 불가
	String id =	(String)session.getAttribute("user_id");
	String aid = "admin";
	
	if(id.equals(aid)){ 
	%>
		
		<h1 style="background-color:#E4FFF5">🎂listAll - 글목록 (관리자용)🎂</h1>
				
				<!-- 바디  -->
				 <div class="box-body">
				 	<table class="table table-bodered">
				 		<tr>
				 			<th style="width: 90px">게시물 번호</th>
					<th> 카테고리 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 작성일 </th>
					
				 		</tr>
				 		<c:forEach var="i" items="${boardList }">
				 		<tr>
				 			<td>${i.board_num }</td>
				 			<td>${i.category }</td>
				 			<td>${i.user_name }</td>
				 			<td>${i.write_date }</td>
				 			<td><a href="/board/boardRead?board_num=${i.board_num }">${i.title }</a></td>
				 		</tr>
				 		</c:forEach>
				 	</table>
				 </div>
				 
				 <div class="box-footer">
				 	<div class="text-center">
				 		<ul class="pagination">
				 			<!-- 이전prev -->
				 			<c:if test="${pm.prev }">
				 				<li><a href="listPage?page=${pm.startPage-1}">&laquo;</a></li>
				 			</c:if>
				 			<!-- 페이지블럭 -->
							<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
								<!-- 삼항연산자를 사용해서 class로 스타일적용  -->
					 			<li ${pm.cri.page == idx? 'class=active':''}>
					 				<a href="listPage?page=${idx }">${idx}</a>
					 			</li>				
							</c:forEach>
				 			<!-- 다음next -->
				 			<c:if test="${pm.next && pm.endPage > 0}">
				 				<li><a href="listPage?page=${pm.endPage+1}">&raquo;</a></li>
				 			</c:if>
				 		</ul>
				 	</div>
				 </div>
				
<% } else {
		%>
		<script type="text/javascript">

		alert("접근할 수 없는 페이지입니다.");
		history.back();
		</script>
		
		<%
	} 
%> 


