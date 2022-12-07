package com.ehcafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {

 	@Inject
	private SqlSession sqlSession;
		
	private static final Logger log = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
		
	private static final String NAMESPACE = "com.ehcafe.mappers.CommentMapper";
		

	
	// 댓글 조회
	@Override
	public List<CommentVO> readComment(int bno) throws Exception {
		log.info("D :readComment (bno) 호출 ");

		return sqlSession.selectList(NAMESPACE+".readComment", bno);
	}



	// 댓글 작성
	@Override
	public void insertComment(CommentVO vo) throws Exception {
		sqlSession.insert(NAMESPACE+".insertComment", vo);
		
	}


	// 댓글 수정
	@Override
	public Integer commentUpdate(CommentVO vo) throws Exception {
		return sqlSession.update(NAMESPACE+".commentUpdate", vo);
	}


	// 댓글 삭제
	@Override
	public Integer deleteReply(Integer reply_num) throws Exception {
		return sqlSession.delete(NAMESPACE+".deleteReply", reply_num);
	}
	
	
	

}
