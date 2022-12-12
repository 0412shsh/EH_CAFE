package com.ehcafe.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehcafe.domain.RoomVO;
import com.ehcafe.persistence.RoomDAO;

@Service
public class RoomServiceImpl implements RoomService {

	
	
	private static final Logger log
	= LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private RoomDAO dao;
	
	
	//상품 등록
	@Override
	public void insert(RoomVO vo) throws Exception {
		dao.insert(vo);
	}


	//상품 조회
	@Override
	public List<RoomVO> list() throws Exception {
		return dao.list();
	}


	//상품 상세 조회
	@Override
	public RoomVO read(int room_num) throws Exception {
		return dao.read(room_num);
	}


	//룸 선택 옵션 출력 조회
	@Override
	public List<RoomVO> listAll() throws Exception {
		return dao.listAll();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
