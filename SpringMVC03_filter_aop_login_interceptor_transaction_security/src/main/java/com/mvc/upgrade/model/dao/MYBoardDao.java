package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.MYBoardDto;

public interface MYBoardDao {
	String NAMESPACE = "board.mapper.";
	
	public List<MYBoardDto> selectList();
	
	public MYBoardDto selectOne(int myno);
	
	public int insert(MYBoardDto dto);
	
	public int update(MYBoardDto dto);
	
	public int delete(int myno);
	
	public String test();
}
