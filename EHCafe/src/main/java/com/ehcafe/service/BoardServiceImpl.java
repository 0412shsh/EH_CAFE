package com.ehcafe.service;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ehcafe.domain.BoardVO;
import com.ehcafe.persistence.BoardDAO;
import com.ehcafe.service.BoardServiceImpl;


@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO dao;
	
	
	//글 작성 
	@Override
	public void boardWrite(BoardVO vo) throws Exception {
		log.info(" S : 글작성 - boardWrite(BoardVO vo) ");
		dao.boardWrite(vo);
	}

	//글쓰기 완료 알럿
	@Override
	public void insertSucc(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('글 등록 완료! 빠른 답변 드리겠습니다.🎂');");
		out.println("location.href='/member/login'");
		out.println("</script>");
		out.close();
	}

	
	//글 보기
	@Override
	public BoardVO getBoard(Integer board_num) throws Exception {
		return dao.getBoard(board_num);
	}
	
	
	
	

	
}
