package com.ehcafe.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.RoomVO;

@Repository
public class RoomDAOImpl implements RoomDAO{
	
	@Inject
	private SqlSession sqlSession;
		
	private static final Logger log = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
		
	private static final String NAMESPACE = "com.ehcafe.mappers.RoomMapper";
	
	
	//상품 등록
	@Override
	public void insert(RoomVO vo) throws Exception {
		log.info("DAO : insert() 실행");
		sqlSession.insert(NAMESPACE+".insert", vo);
		
	}

	
	//상품 조회
	@Override
	public List<RoomVO> list() throws Exception {
		log.info("DAO : list() 실행");
		return sqlSession.selectList(NAMESPACE+".list");
	}


	//상품상세조회
	@Override
	public RoomVO read(int room_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".read",room_num);
	}


	
	//룸 선택 옵션 출력 조회
	@Override
	public List<RoomVO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE+".listAll");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
