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
	
	//이메일 발송
	public void sendEmail(MemberVO vo, String div) throws Exception;
	
	//비밀번호 찾기 
	public void findPw(HttpServletResponse response, MemberVO vo) throws Exception;
	
	//회원정보 조회
	public MemberVO readMember(String user_id);
	
	//회원 탈퇴
	public void delete(MemberVO vo) throws Exception;
	
	//탈퇴 완료 알럿
	public void deleteSucc(HttpServletResponse response) throws Exception;
	
	
}
