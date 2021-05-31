package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Service
public class MYBoardBizImpl implements MYBoardBiz {
	
	@Autowired
	private MYBoardDao dao;

	@Override
	public List<MYBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MYBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MYBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Transactional
	@Override
	public String test() {
		
		/*
		 * transaction(하나로 묶음)이기 때문에 다 성공하거나 다 실패하거나 둘 중 하나여야 함
		 * 
		 * insert가 실행되었지만 그 밑에서 error나서 롤백함
		 * insert도 실행 취소됨
		 */
		
		
		dao.insert(new MYBoardDto(0, "transaction", "test", "insert", null));
		
		String test = dao.test(); // return null
		test.length(); // NullPointerException error
		
		return test;
	}

}
