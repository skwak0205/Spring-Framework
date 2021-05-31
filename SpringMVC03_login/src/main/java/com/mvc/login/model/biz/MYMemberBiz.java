package com.mvc.login.model.biz;


import com.mvc.login.model.dto.MYMemberDto;

public interface MYMemberBiz {
	public MYMemberDto idCheck(String memberid);
	
	public int register(MYMemberDto dto);
	
	public MYMemberDto login(MYMemberDto dto);
	
	public MYMemberDto selectOne(int memberno);
	
	public int update(MYMemberDto dto);
	
	public int delete(int memberno);
}
