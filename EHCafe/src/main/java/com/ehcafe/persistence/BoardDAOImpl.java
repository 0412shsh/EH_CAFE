package com.ehcafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.MemberVO;
import com.ehcafe.service.BoardServiceImpl;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

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

	
	
	//글목록 - 관리자
		@Override
		public List<BoardVO> getBoardListAll() throws Exception {

			List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll");
			log.info("boardList안에 들어 있는 것 : "+boardList);
			return boardList;
		}
		
		
	
	//글목록 - 회원
	@Override
	public List<BoardVO> getBoardListAll2(String user_id) throws Exception {

		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll2",user_id);
		log.info("boardList안에 들어 있는 것 : "+boardList);
		return boardList;
	}

	
	//글수정
	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		log.info( "D : updateBoard() 호출");
		return sqlSession.update(NAMESPACE+".updateBoard", vo);
	}

	//글삭제
	@Override
	public int deleteBoard(int board_num) throws Exception {
		log.info( "D : deleteBoard() 호출");
		return sqlSession.delete(NAMESPACE+".delete",board_num);
	}
	
	
	
	

}
