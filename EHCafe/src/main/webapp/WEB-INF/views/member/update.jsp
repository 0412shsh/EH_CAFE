<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
<script type="text/javascript"></script>
<script>

// 비밀번호 미일치시 제어 
$(document).ready(function(){
	
	$('#update').submit(function(){
		if($('#user_pw').val() != $('#user_pw2').val()){
			alert("비밀번호를 확인하세요.");
			return false;
		}
	
	});
});


//비밀번호 재확인
$(function(){
    $('#user_pw').keyup(function(){
      $('#chkNotice').html('');
    });


$('#user_pw2').keyup(function(){
	if($('#user_pw').val() != $('#user_pw2').val()){
		 $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
         $('#chkNotice').attr('color', '#f82a2aa3');
	} else {
		$('#chkNotice').html('비밀번호 일치함<br><br>');
        $('#chkNotice').attr('color', '#199894b3');
	}
	
	
	});
});
</script>

<h1 style="background-color:#E4FFF5"> update.jsp - 회원수정 </h1>

<form id="update" action="/member/update" method="post">
아이디 : <input type="text" name="user_id" value="${loginVO.user_id }" readonly="readonly"><br>

이름 : <input type="text" name="user_name" readonly="readonly" ><br>

비밀번호 : <input type="password" id="user_pw" name="user_pw"><br>
비밀번호 재확인 : <input type="password" id="user_pw2" ><br>
<font id="chkNotice" size="2"></font>

<input type="submit" value="수정하기">


</form>