package com.ehcafe.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehcafe.domain.MemberVO;
import com.ehcafe.persistence.MemberDAOImpl;


@Repository
public class MemberDAOImpl implements MemberDAO {

	
	
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger log = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String NAMESPACE = "com.ehcafe.mappers.MemberMapper";
	

	
	//회원 가입 
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		log.info("D : insertMember()실행 ");
		sqlSession.insert(NAMESPACE+".insertMember", vo);
		
	}


	//로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("D : login()실행 ");
		
		MemberVO resultVO 
			= sqlSession.selectOne(NAMESPACE+".login", vo);
		
		return resultVO;
	}

	//아이디 중복 체크
	@Override
	public int idCheck(String user_id) throws Exception {
		log.info("D : idCheck()실행 ");
		return sqlSession.selectOne(NAMESPACE+".idCheck", user_id);
	}

	//휴대폰 중복 체크
	@Override
	public int phoneCheck(String user_phone) throws Exception {
		log.info("D : phoneCheck()실행 ");
		return sqlSession.selectOne(NAMESPACE+".phoneCheck", user_phone);
	}

	
	
	
	
	
}
