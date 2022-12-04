package com.ehcafe.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.BoardVO;
import com.ehcafe.domain.Criteria;
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
	
	//페이징
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList(NAMESPACE+".listPage", page);
	}

	//페이징 처리하는 동작(Criteria 객체 사용)
	@Override
	public List<BoardVO> listPageCri(Criteria cri) throws Exception {
		System.out.println("DAO: listPageCri 호출");
		return sqlSession.selectList(NAMESPACE+".listPageCri", cri);
	}

	//DB 테이블에 있는 모든 글 개수 계산 후 리턴
	@Override
	public int pageCount() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".pageCount");
	}
	
	

}
