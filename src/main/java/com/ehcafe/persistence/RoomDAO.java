package com.ehcafe.persistence;

import java.util.List;

import com.ehcafe.domain.RoomVO;

public interface RoomDAO {

	//상품등록
	public void insert(RoomVO vo) throws Exception;
	
	//상품조회
	public List<RoomVO> list() throws Exception;
	
	//상품상세조회
	public RoomVO read(int room_num) throws Exception;
	
	//룸 선택 옵션 출력 조회
	public List<RoomVO> listAll() throws Exception;
	
	
	
}
