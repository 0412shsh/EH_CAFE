<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>
<script>

</script>

<h1 style="background-color:#E4FFF5"> delete.jsp - 회원탈퇴 </h1>

<form action="/member/delete" method="post">
<h3>아이디</h3>
<input type="text" id="user_id" name="user_id" value="${loginVO.user_id }"  readonly="readonly">
<h3>비밀번호</h3>
<input type="password" id="user_pw" name="user_pw" >

<input type="submit" value="탈퇴하기">
</form>

<div>
<c:if test="${msg == false}">
	비밀번호가 맞지 않습니다. 
</c:if>
</div>