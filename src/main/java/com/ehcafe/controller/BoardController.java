package com.ehcafe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehcafe.controller.BoardController;
import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.CommentVO;
import com.ehcafe.domain.Criteria;
import com.ehcafe.service.BoardService;
import com.ehcafe.service.CommentService;
import com.ehcafe.domain.PageMaker;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@Inject
	private CommentService cService;
	
	
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
		
		return "/board/listAll2";
	}
	
	// ------------------------------------------------------------
	
	// 글내용 
	@RequestMapping(value="/boardRead", method=RequestMethod.GET)
	public void boardReadGET(@RequestParam("board_num") int board_num, Model model) throws Exception{
		log.info("C: 글내용  - boardReadGET() 호출 ");
		log.info(board_num + " --------------bno");
		model.addAttribute("vo", service.getBoard(board_num));
		log.info("board 정보들 : "+service.getBoard(board_num));
		
		// 댓글 12/05 추가 
		List<CommentVO> commentList = cService.readComment(board_num);
		model.addAttribute("commentList",commentList);
		model.addAttribute("commentVO", cService.readComment(board_num));
		
		log.info("commentVO========="+cService.readComment(board_num));
		
		
	}
	
	// 글 전체 11/28 - 관리자(문의전체 조회 가능) $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$삭제 가능성 큼
//	@RequestMapping(value="/listAll", method = RequestMethod.GET)
//	public void listAllGET(Model model, HttpSession session) throws Exception {
//		log.info("C: 글내용  - listAllGET() 호출 ");
//		String user_id = (String)session.getAttribute("user_id");
//		log.info("user_id는 뭘까여>????????"+user_id);
//		List<BoardVO> boardList = service.getBoardListAll();
//		
//		model.addAttribute("boardList", boardList);
//		
//		
//	}
	
//	// 글 전체 11/28 - 회원
	@RequestMapping(value="/listAll2", method = RequestMethod.GET)
	public void listAllGET2(Model model, HttpSession session) throws Exception {
		log.info("C: 글내용  - listAllGET2() 호출 ");
		String user_id = (String)session.getAttribute("user_id");
		log.info("user_id는 뭘까여>????????"+user_id);
		List<BoardVO> boardList2 = service.getBoardListAll2(user_id);
		
		model.addAttribute("boardList2", boardList2);
		
		
	}
	
	// 글 수정 11/29 GET : 기존 정보 출력 + 수정할 정보 입력
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("board_num") int board_num, Model model) throws Exception{
		log.info("modifyGET() 호출");
		log.info("가져온 정보 : "+board_num);
		model.addAttribute("vo", service.getBoard(board_num));
		
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception{
		log.info("modifyPOST() 호출");
		log.info("수정할 정보:" + vo);
		
		int cnt = service.updateBoard(vo);
		
		// 수정 성공시 /listAll 페이지로 이동
		if(cnt==1) {
			return "redirect:/board/listAll2";
		} else {
			new NullPointerException();
			return "/board/modify?board_num="+vo.getBoard_num();
		}
		
	}
	
	// 글 수정 11/29 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	// 글 삭제 11/29 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deletePOST(@RequestParam("board_num") int board_num,RedirectAttributes rttr) throws Exception{
		log.info("C : 글 삭제 - deletePOST() 호출 ");
		log.info("C : 삭제할 게시글 번호"+board_num );
		
		service.deleteBoard(board_num);
		log.info("게시글 삭제 완료!@@@@@@@@@@@@"+board_num);
		
		return "redirect:/board/listAll2";
	}
	
	
	// 글 삭제 11/29 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	
	// 12/04 페이징처리 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	//글목록보기(PageMaker객체 사용) -- 관리자 전용 
	// http://localhost:8088/board/listPage
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPageGET(Criteria cri, Model model) throws Exception{
		
		
		model.addAttribute("boardList", service.listCri(cri));

		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.pageCount()); //DB의 전체ROW수 입력

		// 뷰페이지로 전달 
		model.addAttribute("pm", pm);
		
	
		
	}
	
	//글목록보기(PageMaker객체 사용) -- 관리자 전용 
	@RequestMapping(value = "/listPage2", method = RequestMethod.GET)
	public void listPage2GET(Criteria cri, Model model) throws Exception{
		model.addAttribute("boardList", service.listCri(cri));

		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.pageCount()); //DB의 전체ROW수 입력

		// 뷰페이지로 전달 
		model.addAttribute("pm", pm);
		
			}
	
		
	
	// 12/04 페이징처리 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			
	//12/05 댓글 작성 ###########################################################
	
	
	//댓글 작성 
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	public String insertComment(CommentVO vo, RedirectAttributes rttr) throws Exception {
		log.info("C : insertComment()  실행 ");
		log.info("CommentVO 안에 들어 있는것? "+ vo);
		cService.insertComment(vo);
		
		rttr.addAttribute("board_num",vo.getBoard_num());
		
		
		
		return "redirect:/board/boardRead";
	}
	//12/05 댓글 작성 ###########################################################
	
	
	// 댓글 수정 12/07 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//댓글 수정
			@RequestMapping(value="/updateReply", method = RequestMethod.POST)
			public String updateReply(@RequestParam("reply_num") int reply_num, @RequestParam("board_num") int board_num, CommentVO vo, RedirectAttributes rttr) throws Exception{
				//전달 정보 저장
				log.info(reply_num + "@@@@@@@@@@@" + board_num+"@@@@@@@@@@@@@@@@@@@");
				//int page = (Integer.parseInt(request.getParameter("page")));
				//서비스 - 댓글수정
				cService.commentUpdate(vo);
				
				log.info("댓글 수정 완료");
				
				return "redirect:/board/boardRead?board_num="+board_num;
			}
	
	// 댓글 수정 12/07 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
}
