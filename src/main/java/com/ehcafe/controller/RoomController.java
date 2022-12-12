package com.ehcafe.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehcafe.domain.RoomVO;
import com.ehcafe.service.RoomService;

@Controller
@RequestMapping("/room/*")
public class RoomController {

private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private RoomService service;
	
	
	
	// 상품등록
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insert() throws Exception {
		log.info("C : 상품등록 - insert () 호출");
			
			
		}
		
	
	
	// 상품등록
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(RoomVO vo) throws Exception {
		log.info("C : 상품등록 - insert () 호출");
		
		service.insert(vo);
		
		return "redirect:/room/list"; 
	}
	
	// 상품 조회
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		log.info("C : 전체상품조회 - list() 호출");
		
		model.addAttribute("list",service.list());
		
		return "/room/list";
	}
	
	// 상품 상세 조회
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(RoomVO vo,Model model) throws Exception {
		log.info("C : 상품상세조회 - read() 호출");
		
		log.info("service.list()안에 든건? "+service.read(vo.getRoom_num()));
		model.addAttribute("read",service.read(vo.getRoom_num()));
		model.addAttribute("testList", service.listAll());
		return "/room/read";
		
	}
}
