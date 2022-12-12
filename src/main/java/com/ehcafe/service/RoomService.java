package com.ehcafe.service;

import java.util.List;

import com.ehcafe.domain.RoomVO;

public interface RoomService {

	//상품 등록
	public void insert(RoomVO vo) throws Exception;
	
	//상품 조회
	public List<RoomVO> list() throws Exception;

	//상품 상세 조회
	public RoomVO read(int room_num) throws Exception;
	
	//룸 선택 옵션 출력 조회
	public List<RoomVO> listAll() throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
