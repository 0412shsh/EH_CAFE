package com.ehcafe.service;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
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



	// 비밀번호 찾기 - 이메일 발송하기
	@Override
	public void sendEmail(MemberVO vo, String div) throws Exception {
		// Mail 서버 설정 
		String charSet = "utf-8";
		String hostSMTP ="smtp.naver.com";
		String hostSMTPid = "0412corn@naver.com";
		String hostSMTPpwd = "loveksk0412";
		
		//보내는 사람 Email, 제목, 내용 
		String fromEmail = "0412corn@naver.com";
		String fromName = "은하카페";
		String subject ="";
		String msg ="";
		
		if(div.equals("findpw")) {
			subject = "💖은하카페 임시 비밀번호입니다.💖";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: pink;'>";
			msg += "🎂"+vo.getUser_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.🎂</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += vo.getUser_pw() + "</p></div>";
			
		}
		
		// 받는 사람 E-Mail 주소
		String mail = vo.getUser_email();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
			
			log.info("S : 임시비밀번호 전송 성공 @@@@@@@@ ");
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}


	

	// 비밀번호 찾기
	@Override
	public void findPw(HttpServletResponse response,MemberVO vo) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		MemberVO ck = dao.readMember(vo.getUser_id()); //
		
		// 가입된 아이디 없으면
		if(dao.idCheck(vo.getUser_id()) == 0) {
			log.info(dao.idCheck(vo.getUser_id())+"==>  1일 경우 아이디 있음,0일 경우 아이디 없음");
			log.info("D : 아이디 존재 체크 실행");
			out.print("아이디가 존재하지 않습니다.");
			out.close();
		
			
		}
		else if(!vo.getUser_email().equals(ck.getUser_email())) {
			log.info("D : 이메일 존재 체크 실행");
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		} else {
			String pw ="";
			for(int i=0; i<12; i++) {
				pw += (char)((Math.random()*26)+97);
			}
			vo.setUser_pw(pw);
			//비밀번호 변경
			dao.updatePw(vo);
			//비밀번호 변경 메일 발송
			sendEmail(vo,"findpw");
			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
		
	}




	//회원정보보기
	@Override
	public MemberVO readMember(String user_id) {
		log.info("S : readMember() 호출");
		MemberVO vo = null;
		try {
			vo = dao.readMember(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



	//회원 탈퇴
	@Override
	public void delete(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
	}

	
	
	//로그인 실패 알럿
		@Override
		public void deleteSucc(HttpServletResponse response) throws Exception {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴되었습니다. 다음에 또 찾아주세요 🎂 ');");
			out.println("location.href='/'");
			out.println("</script>");
			out.close();		
		}
	

	
}
