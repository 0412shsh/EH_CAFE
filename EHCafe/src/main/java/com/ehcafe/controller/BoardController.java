package com.ehcafe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehcafe.controller.BoardController;
import com.ehcafe.domain.BoardVO;
import com.ehcafe.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	
	// ------------------------------------------------------------
	
	// 글쓰기 페이지 불러오기
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public void insertBoardGET() throws Exception {
		log.info("C : insertBoardGET() - 글쓰기 페이지 호출 ");
		
	}
	
	
	// 글 쓰기 
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoardPOST(BoardVO vo, HttpSession session, HttpServletResponse response) throws Exception {
		log.info("C : insertBoardPOST() - 글쓰기 작성 호출 ");
		log.info("C : 글작성 정보 @@ "+vo);
		
		service.boardWrite(vo);
		log.info("C : 글작성 성공 ");
		
		service.insertSucc(response);
		
		return "/member/login";
	}
	

	
}
