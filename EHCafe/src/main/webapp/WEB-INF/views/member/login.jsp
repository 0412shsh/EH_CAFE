<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$('#login').submit(function(){
			//alert("🎂 로그인 성공~! 다시 돌아오신 걸 환영합니다.🎂");
			if($('#user_id').val() ==""){
				alert("아이디를 입력하세요.");
				return false;			
			}
			if($('#user_pw').val() ==""){
				alert("비밀번호를 입력하세요");
				return false;			
			}
		}); //샵 로긴
	}); //도큐멘트 레디
</script>



<h1 style="background-color:#E4FFF5"> login.jsp - 로그인 </h1>

<form action="/member/login" method="post" id="login">
	ID : <input type="text" id=user_id name="user_id" ><br>
	PW : <input type="password" id=user_pw name="user_pw" ><br>
	<input style="background-color:#E4FFF5" type="submit" value="🎂로그인🎂">


</form>