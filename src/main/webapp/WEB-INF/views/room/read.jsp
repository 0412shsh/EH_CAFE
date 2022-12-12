<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp" />

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>
<script>

</script>

<h1 style="background-color:#E4FFF5"> read.jsp - 룸 상세 정보</h1>



제목 : ${read }

<h2>Room Name : ${read.room_name } </h2>
<h3>Detail : ${read.detail }</h3> 
<h3>Price : \<fmt:formatNumber type="number" value="${read.price }"/>
</h3>

<hr>
등록된 룸들 select 박스로 뿌리기<br>
<c:if test="${!empty testList }">
	<select name="selectBox" id="selectBox" style="width:80px;" class="select_02">
	<c:forEach var="testList" items="${testList }">
		<option value="${testList.room_name }">${testList.room_name }</option>
	</c:forEach>
	</select>

</c:if>