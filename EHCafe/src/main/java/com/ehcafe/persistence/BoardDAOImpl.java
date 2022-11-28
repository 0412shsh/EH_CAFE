package com.ehcafe.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	//SQLSession 객체 (디비 연결, 마이바티스, 자원해제)
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper의 가상 이름 정의
	private static final String NAMESPACE = "com.ehcafe.mappers.BoardMapper";
	
	
	//글 쓰기
	@Override
	public void boardWrite(BoardVO vo) throws Exception {

		int result = sqlSession.insert(NAMESPACE+".boardWrite",vo);
		
		
	}

	//글 보기
	@Override
	public BoardVO getBoard(Integer board_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getBoard", board_num);
	}
	
	
	
	

}
