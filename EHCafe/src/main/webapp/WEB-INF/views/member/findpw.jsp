<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>
<script>
	$(function(){
		$('#findBtn').click(function(){
			//alert("비밀번호 찾기 실행");
			$.ajax({
				url : "/member/findpw",
				type : "POST",
				data : {
					user_id : $("#user_id").val(),
					user_email : $("#user_email").val()
				},
				success : function(result) {
					alert(result);
				},
			}); //ajax 
		});
	});

</script>

<h1 style="background-color:#E4FFF5"> findpw.jsp - 비밀번호 찾기 </h1>

<label> 아이디 </label>
<input type="text" id="user_id" name="user_id" placeholder="회원가입한 아이디를 입력하세요."><br>
<label> 이메일 </label>
<input type="email" id="user_email" name="user_email" placeholder="회원가입한 이메일을 입력하세요."><br>

<button type="button" id="findBtn">찾아줭</button>
<button type="button" onclick="location.href='/member/login'">로그인으로</button>