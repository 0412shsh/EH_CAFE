<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 헤더 -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">🎂listAll2 - 글목록 (개인회원용)🎂</h1>


${boardList2} <hr>


	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 90px">게시물 번호</th>
					<th> 카테고리 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 작성일 </th>
				</tr>
				
				<c:forEach var="vo" items="${boardList2 }">
				<tr>
					<td>${vo.board_num }</td>
					<td>${vo.category }</td>
					<td><a href="/board/boardRead?board_num=${vo.board_num}">${vo.title }</a></td>
					<td>${vo.user_name }</td>
					<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }"/></td>
				</tr>
				</c:forEach>
		</tbody>
		</table>
	</div>

<button type="button" onclick="location.href='/board/insertBoard'">글등록</button>
<button type="button" onclick="location.href='/'">메인화면</button>