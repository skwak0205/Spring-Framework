package com.mvc.login.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.login.model.dao.MYMemberDao;
import com.mvc.login.model.dto.MYMemberDto;

@Service
public class MYMemberBizImpl implements MYMemberBiz {
	
	@Autowired
	private MYMemberDao dao;
	
	@Override
	public MYMemberDto idCheck(String memberid) {
		return dao.idCheck(memberid);
	}

	@Override
	public int register(MYMemberDto dto) {
		return dao.register(dto);
	}

	@Override
	public MYMemberDto login(MYMemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public MYMemberDto selectOne(int memberno) {
		return dao.selectOne(memberno);
	}

	@Override
	public int update(MYMemberDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int memberno) {
		return dao.delete(memberno);
	}

}
