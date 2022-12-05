package com.ehcafe.service;

import java.util.List;

import com.ehcafe.domain.CommentVO;

public interface CommentService {

	//댓글 조회
	public List<CommentVO> readComment(int bno) throws Exception;
	
	//댓글 작성
	public void insertComment(CommentVO vo) throws Exception;
	
	
}
