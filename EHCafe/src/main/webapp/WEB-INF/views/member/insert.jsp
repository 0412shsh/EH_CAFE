<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 탄생시 주석 풀기 -->
<%-- <%@ include file="../include/header.jsp" %>  --%>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
<script type="text/javascript">



</script>

<script>



	$(document).ready(function(){
		
		$('#join').submit(function(){
			if($('#user_id').val() == ""){
				alert("아이디를 입력하세요.");
				return false;
			}
	
			if($('#user_pw').val() == ""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			
			if($('#user_name').val() == ""){
				alert("이름을 입력하세요.");
				return false;
			}
			
			if($('#user_email').val() == ""){
				alert("이메일을 입력하세요.");
				return false;
			}
			
			if($('#user_phone').val() == ""){
				alert("전화번호를 입력하세요.");
				return false;
			}
		
		
		
		
		}); //#join submit 
		
		$('#user_id').keyup(function(){
			let user_id = $('#user_id').val();
			$.ajax({
				url:"/member/idcheck",
				type:"post",
				data : {user_id: user_id},
				dataType : 'json',
				success : function(result){
					if(result == 1){
						$("#id_feedback").html('이미 사용중인 아이디입니다.');
						$("#id_feedback").attr('color','#dc3545');
					} else{
						$("#id_feedback").html('사용할 수 있는 아이디입니다.');
						$("#id_feedback").attr('color','#72FBC6');
					} 
				},
				error : function(){
					alert("서버요청실패");
				}
			});
				 
		});
		
		$('#user_phone').keyup(function(){
			let user_phone = $('#user_phone').val();
			$.ajax({
				url:"/member/phonecheck",
				type:"post",
				data : {user_phone: user_phone},
				dataType : 'json',
				success : function(result){
					if(result == 1){
						$("phone_feedback").html('이미 사용중인 전화번호입니다.');
						$("#phone_feedback").attr('color','#dc3545');
					} else{
						$("#phone_feedback").html('사용할 수 있는 전화번호입니다.');
						$("#phone_feedback").attr('color','#72FBC6');
					} 
				},
				error : function(){
					alert("서버요청실패");
				}
			});
				 
		});
		
	}); //document.ready
</script>


    
    <h1 style="background-color:#E4FFF5"> 🎂insert.jsp - 회원가입🎂 </h1>
    <h2> Join </h2>
    
    
    <form action="/member/insert" id="join" method="post">

	아이디 : <input type="text" name="user_id" id="user_id" placeholder="아이디를 입력하세요.">
	<div><font id="id_feedback" size="2"></font></div>
	비밀번호 : <input type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요."><br>
	이메일 : <input type="email" name="user_email" id="user_email" placeholder="이메일을 입력하세요.">
	이름 : <input type="text" name="user_name" id="user_name" placeholder="이름을 입력하세요."><br>
	전화번호 : <input type="text" name="user_phone" id="user_phone" placeholder="(-)제외 후 숫자만 입력하세요."><br>
	<div><font id="phone_feedback" size="2"></font></div>
    <input style="background-color:#E4FFF5" type="submit" value="🎂회원가입🎂" id="submit">
    </form>