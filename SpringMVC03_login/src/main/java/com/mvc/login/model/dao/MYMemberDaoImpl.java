package com.mvc.login.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.login.model.dto.MYMemberDto;

@Repository
public class MYMemberDaoImpl implements MYMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MYMemberDto idCheck(String memberid) {
		MYMemberDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"idCheck", memberid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int register(MYMemberDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"register", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public MYMemberDto login(MYMemberDto dto) {
		MYMemberDto user = null;
		
		try {
			user = sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
	}

	@Override
	public MYMemberDto selectOne(int memberno) {
		MYMemberDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"userinfo", memberno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int update(MYMemberDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateinfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int memberno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteinfo", memberno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
