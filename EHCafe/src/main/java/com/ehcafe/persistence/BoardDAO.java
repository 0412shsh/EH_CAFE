package com.ehcafe.persistence;

import com.ehcafe.domain.BoardVO;

public interface BoardDAO {

	
	//글쓰기
		public void boardWrite(BoardVO vo) throws Exception;
		
		
}
