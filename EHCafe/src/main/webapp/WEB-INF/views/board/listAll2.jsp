<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ํค๋ -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">๐listAll2 - ๊ธ๋ชฉ๋ก (๊ฐ์ธํ์์ฉ)๐</h1>


${boardList2} <hr>


	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 90px">๊ฒ์๋ฌผ ๋ฒํธ</th>
					<th> ์นดํ๊ณ ๋ฆฌ </th>
					<th> ์ ๋ชฉ </th>
					<th> ์์ฑ์ </th>
					<th> ์์ฑ์ผ </th>
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

<button type="button" onclick="location.href='/board/insertBoard'">๊ธ๋ฑ๋ก</button>
<button type="button" onclick="location.href='/'">๋ฉ์ธํ๋ฉด</button>