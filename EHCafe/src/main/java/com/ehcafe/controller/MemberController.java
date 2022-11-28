package com.ehcafe.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehcafe.controller.MemberController;
import com.ehcafe.domain.MemberVO;
import com.ehcafe.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	
	// ▼▼▼▼▼▼▼▼ 11/26 회원가입 시작 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insertGET() throws Exception {
		log.info("insertGET() 호출");
		log.info("insert.jsp 로 연결");
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPOST(MemberVO vo,HttpServletResponse response) throws Exception {
		log.info("insertPOST() 호출");
		service.insertMember(vo);
		log.info("C : 회원가입 완료! ");
		service.insertSucc(response);
	
		
		return "/member/login";
	}
	
	//아이디 중복체크 
	@RequestMapping(value="/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("user_id") String user_id) throws Exception {
		log.info("idCheck() 호출 ");
		int result = service.idCheck(user_id);
		return result;
	}
	
	
	//휴대폰 중복체크 
	@RequestMapping(value="/phonecheck", method = RequestMethod.POST)
	@ResponseBody
		public int phoneCheck(@RequestParam("user_phone") String user_phone) throws Exception {
			log.info("phoneCheck() 호출 ");
			int result = service.phoneCheck(user_phone);
			log.info("휴대폰 중복체크 결과 : "+result);
			return result;
		}
	
	// ▲▲▲▲▲▲▲▲ 11/26 회원가입 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	
	
	
	// ▼▼▼▼▼▼▼▼ 11/26 로그인 시작 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	// 로그인 - GET
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGET() throws Exception {
		log.info("C : login() 실행 ");
		log.info("C : login.jsp 뷰페이지로 이동");
		
		return "/member/login";
	}
	
	// 로그인 - POST
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session, Model model,HttpServletResponse response) throws Exception {
		log.info("C : loginPOST() 실행 ");	
		log.info("C : vo는 "+vo);
		
		MemberVO loginVO = service.login(vo);
		log.info("C : loginVO 안에는 : "+loginVO + "@@@ null값일 경우 사용자 입력값이 DB와 다름!!! ");
		
		//로그인 여부 확인
		if(loginVO !=null) {
			//DB에 아이디, 비밀번호 정보 존재
			session.setAttribute("loginVO", loginVO);
			session.setAttribute("user_id", vo.getUser_id());
			session.setAttribute("user_name", vo.getUser_name());
			model.addAttribute("loginVO", loginVO);
//			service.loginSucc(response);
			
			return "/home"; // @@@@@@@@@@@@@로그인 성공 후 주소가 /member/login 임 ㅜ @@@@@@@@@@@@
			
		} else {
			//DB에 아이디, 비밀번호 정보 존재 X - 실패 
			service.loginFail(response);
			
			return "/member/login";
		}
		
	}
	
	
	// ▲▲▲▲▲▲▲▲ 11/26 로그인 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
}
