package com.ehcafe.persistence;

import com.ehcafe.domain.MemberVO;

public interface MemberDAO {

	//회원가입 동작
	public void insertMember(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	//아이디 중복 체크 
	public int idCheck(String user_id) throws Exception;
	
	//휴대폰 중복 체크 
	public int phoneCheck(String user_phone) throws Exception;
	
	//회원정보조회
	public MemberVO readMember(String user_id) throws Exception;
	
	//비밀번호 변경
	public int updatePw(MemberVO vo) throws Exception;
	
	//회원 탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
}
