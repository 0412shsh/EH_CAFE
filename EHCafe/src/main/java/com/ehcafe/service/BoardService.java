package com.ehcafe.service;

import javax.servlet.http.HttpServletResponse;

import com.ehcafe.domain.BoardVO;

public interface BoardService {

	
	//글쓰기
	public void boardWrite(BoardVO vo) throws Exception;
	
	//글쓰기 완료 알럿
	public void insertSucc(HttpServletResponse response) throws Exception;
	
	
	
}
