package com.ehcafe.persistence;

import java.util.List;

import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.MemberVO;

public interface BoardDAO {

	
	//글쓰기
		public void boardWrite(BoardVO vo) throws Exception;
		
	//글보기
	public BoardVO getBoard(Integer board_num) throws Exception;
	
	//글목록 - 관리자
			public List<BoardVO> getBoardListAll() throws Exception;
	
	//글목록 - 회원
		public List<BoardVO> getBoardListAll2(String user_id) throws Exception;
		
	//글수정 
		public int updateBoard(BoardVO vo) throws Exception;
		
	//글삭제
		public int deleteBoard(int board_num) throws Exception;
		
}
