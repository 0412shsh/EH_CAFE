package com.ehcafe.service;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.MemberVO;
import com.ehcafe.persistence.BoardDAO;

public interface BoardService {

	
	//글쓰기
	public void boardWrite(BoardVO vo) throws Exception;
	
	//글쓰기 완료 알럿
	public void insertSucc(HttpServletResponse response) throws Exception;
	
	//글보기
	public BoardVO getBoard(Integer board_num) throws Exception;
	
	//글목록 (관리자유무 판단) 
//	public void adminCheck(HttpServletResponse response, String user_id) throws Exception;
	
	//글목록 (관리자 전용으로 전체 회원 글 보기)
	public List<BoardVO> getBoardListAll() throws Exception;
	
	//글목록- 특정인
	public List<BoardVO> getBoardListAll2(String user_id) throws Exception;
	
	//글수정
	public int updateBoard(BoardVO vo) throws Exception;
	
	//글삭제
	public int deleteBoard(int board_num) throws Exception;
}
