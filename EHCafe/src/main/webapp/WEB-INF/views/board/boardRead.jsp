<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ํค๋ -->
<jsp:include page="../include/header.jsp" />

<h1 style="background-color:#E4FFF5">๐boardRead - ๊ฒ์๊ธ ๋ด์ฉ๋ณด๊ธฐ ๐</h1>

<!-- ๊ฒ์๊ธ ํค๋  -->
	์นดํ๊ณ ๋ฆฌ : ${vo.category }<br>
	์ ๋ชฉ : ${vo.title } <br>
	์์ฑ์ : ${vo.user_name }<br>
	์์ฑ์๊ฐ : 
	<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }" />
<!-- ๊ฒ์๊ธ ํค๋  -->

<!-- ๊ฒ์๊ธ ๋ณธ๋ฌธ -->
	${vo.content }
<!-- ๊ฒ์๊ธ ๋ณธ๋ฌธ -->

<!-- ๊ฒ์๊ธ ๋ฒํผ -->
<button type="button" onclick="location.href='/board/listAll2'">๋ชฉ๋ก</button>
<button type="button" onclick="location.href='/board/modify?board_num='+'${vo.board_num}'">์์ </button>
<button type="button" onclick="location.href='/board/delete?board_num='+'${vo.board_num}'">์ญ์ </button>
<!-- ๊ฒ์๊ธ ๋ฒํผ -->

