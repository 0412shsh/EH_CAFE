<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$('#login').submit(function(){
			//alert("๐ ๋ก๊ทธ์ธ ์ฑ๊ณต~! ๋ค์ ๋์์ค์  ๊ฑธ ํ์ํฉ๋๋ค.๐");
			if($('#user_id').val() ==""){
				alert("์์ด๋๋ฅผ ์๋ ฅํ์ธ์.");
				return false;			
			}
			if($('#user_pw').val() ==""){
				alert("๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์");
				return false;			
			}
		}); //์ต ๋ก๊ธด
	}); //๋ํ๋ฉํธ ๋ ๋
</script>



<h1 style="background-color:#E4FFF5"> login.jsp - ๋ก๊ทธ์ธ </h1>

<form action="/member/login" method="post" id="login">
	ID : <input type="text" id=user_id name="user_id" ><br>
	PW : <input type="password" id=user_pw name="user_pw" ><br>
	<input style="background-color:#E4FFF5" type="submit" value="๐๋ก๊ทธ์ธ๐">


</form>