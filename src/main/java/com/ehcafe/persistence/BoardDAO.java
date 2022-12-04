package com.ehcafe.persistence;

import java.util.List;


import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.Criteria;

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
		
		//특정 페이지에 있는 글정보를 확인 
		public List<BoardVO> listPage(int page) throws Exception;
			
		//페이징 처리하는 동작(Criteria 객체 사용)
		public List<BoardVO> listPageCri(Criteria cri) throws Exception;

		//DB 테이블에 있는 모든 글 개수 계산 후 리턴
		public int pageCount() throws Exception;
		
}
