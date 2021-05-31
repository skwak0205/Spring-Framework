package com.mvc.login.model.dao;

import com.mvc.login.model.dto.MYMemberDto;

public interface MYMemberDao {
	
	String NAMESPACE = "member.mapper.";
	
	public MYMemberDto idCheck(String memberid);
	
	public int register(MYMemberDto dto);
	
	public MYMemberDto login(MYMemberDto dto);
	
	public MYMemberDto selectOne(int memberno);
	
	public int update(MYMemberDto dto);
	
	public int delete(int myno);
}
