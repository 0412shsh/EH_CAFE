package com.ehcafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehcafe.domain.CommentVO;
import com.ehcafe.persistence.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{

	@Inject
	private CommentDAO dao;
	
	// 댓글 조회
	@Override
	public List<CommentVO> readComment(int bno) throws Exception {
		return dao.readComment(bno);
	}

	// 댓글 작성 
	@Override
	public void insertComment(CommentVO vo) throws Exception {
		dao.insertComment(vo);
	}
	
	

}
