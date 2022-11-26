package com.ehcafe.service;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehcafe.domain.MemberVO;
import com.ehcafe.persistence.MemberDAO;
import com.ehcafe.service.MemberServiceImpl;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger log
	= LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO dao;
	
	

	// 회원가입
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		log.info("S : insertMember(vo) 호출 ");
		dao.insertMember(vo);
	}


	
	
	//회원가입 완료 알럿 
	@Override
	public void insertSucc(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입완료! 환영합니다.🎂');");
		out.println("location.href='/member/login'");
		out.println("</script>");
		out.close();
		
	}





	//로그인 
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("S : login(vo) 호출 ");
		MemberVO loginVO = dao.login(vo);
		return loginVO;
	}

	
	
	//로그인 성공 알럿
	@Override
	public void loginSucc(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('돌아오신 것을 환영합니다.🎂');");
		out.println("location.href='/member/home'");
		out.println("</script>");
		out.close();
		
	}



	//로그인 실패 알럿
	@Override
	public void loginFail(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.      입력하신 내용을 다시 확인해주세요.');");
		out.println("location.href='/member/login'");
		out.println("</script>");
		out.close();		
	}


	//아이디 중복 체크
	@Override
	public int idCheck(String user_id) throws Exception {
		return dao.idCheck(user_id);
	}


	//휴대폰 중복 체크
	@Override
	public int phoneCheck(String user_phone) throws Exception {
		return dao.phoneCheck(user_phone);
	}
	
	
	
	
	
	
	
}
