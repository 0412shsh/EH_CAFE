package com.ehcafe.controller;


import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	// ▼▼▼▼▼▼▼▼ 11/29 로그아웃 시작 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception{
		session.invalidate();
		log.info("C : 세션 초기화 완료 - 로그아웃");
		return "redirect:/";
	}
	// ▲▲▲▲▲▲▲▲ 11/29 로그아웃 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	
	// ▼▼▼▼▼▼▼▼ 12/2 비밀번호 찾기 시작 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	@RequestMapping(value="/findpw", method=RequestMethod.GET)
	public void findPwGet() throws Exception {
		log.info("C :findPwGet() 호출 ");
		
		
	}
	@RequestMapping(value="/findpw", method=RequestMethod.POST)
	public void findPwPost(@ModelAttribute MemberVO member, HttpServletResponse response) throws Exception {
		log.info("C :findPwPOST() 호출 ");
		log.info("@@@@@@@@@@@@@"+member);
		service.findPw(response, member);
		
		
	}
	
	// ▲▲▲▲▲▲▲▲ 12/2 비밀번호 찾기 로그아웃 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	
	
	// 12/3 회원탈퇴 & 회원정보 수정 시작 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public void deleteGET() throws Exception {
		log.info("deleteGET() 호출");
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deletePOST(MemberVO vo, HttpSession session, RedirectAttributes rttr, HttpServletResponse response) throws Exception {
		log.info("deletePOST() 호출");
		log.info("C : vo 안에 들어 있는 것은? (스프링 자동 매치, form으로 부터 입력 받은거) "+vo); 
		
		//세션에 있는 member를 가져와 member변수에 넣어준다. 
		MemberVO member = (MemberVO)session.getAttribute("loginVO");
		log.info("세션에서 가져와 담긴 것은? "+member );
		
		//세션에 있는 비밀번호
		String sessionPw = member.getUser_pw();
		log.info("세션에 담긴 비밀번호는? "+sessionPw);
		
		//사용자가 입력해 --> vo로 들어오는 비밀번호 
		String voPw = vo.getUser_pw();
		log.info("사용자가 입력한 비밀번호는? "+voPw);
		
		
		//비밀번호가 불일치시 msg에 false를 담아 delete 뷰로 보내기
		if(!(sessionPw.equals(voPw))) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:/member/delete";
		}
		
		service.deleteSucc(response);
		service.delete(vo);
		session.invalidate();
		
		
		
		return "redirect:/";
		
		
	}
	// 회원정보 수정 - GET
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public void updateMemberGET() throws Exception {
		log.info(" updateMemberGET() 호출");
	}
	
	// 회원정보 수정 - POST
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void updateMemberPOST(MemberVO vo, HttpServletResponse response, HttpSession session ) throws Exception {
		log.info(" updateMemberPOST() 호출");
		service.updateSucc(response);
		service.memberUpdate(vo);
		session.invalidate();
	}
	
	
	
	// 12/3 회원탈퇴 & 회원정보 수정 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	
	
}
