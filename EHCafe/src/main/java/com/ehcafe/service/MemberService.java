package com.ehcafe.service;

import javax.servlet.http.HttpServletResponse;

import com.ehcafe.domain.MemberVO;

public interface MemberService {

	
	//회원가입 
	public void insertMember (MemberVO vo)throws Exception;
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	//회원가입 완료 알럿
	public void insertSucc(HttpServletResponse response)throws Exception;
	
	//로그인 - 성공 알럿
	public void loginSucc(HttpServletResponse response)throws Exception;
	
	//로그인 - 실패 알럿
	public void loginFail(HttpServletResponse response)throws Exception;
	
	//아이디 중복 체크 
	public int idCheck(String user_id) throws Exception;
	
	//휴대폰 중복 체크 
	public int phoneCheck(String user_phone) throws Exception;
	
}
