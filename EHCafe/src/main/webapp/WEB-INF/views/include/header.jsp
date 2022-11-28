<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 로그인 판별  -->
<c:if test="${user_id != null }">
	<b>${loginVO.user_name}</b>님 환영합니다.
</c:if>

<!-- 로그인 판별 2 -->
<c:if test="${user_id == null }">
로그인 세션 없음 
<!-- <a href="/member/login"><i class="fa fa-user" aria-hidden="true"></i> <span>Login</span></a> -->
</c:if>

<!-- 로그인 판별 3 - 로그인 O -->
<c:if test="${user_id != null }">
로그인 세션 있음
<!--  <a href="/member/mypage"><i class="fa fa-user" aria-hidden="true"></i> <span>MyPage</span></a> -->
</c:if>
