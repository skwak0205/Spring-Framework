package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JdbcDto;

@Repository
public class JdbcDaoImpl implements JdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<JdbcDto> selectList() {
		
		List<JdbcDto> list = new ArrayList<JdbcDto>();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
		
//		list = jdbcTemplate.query(sql, (rs, rowNum)->{ // lambda식 원래는 RowMapper(ResultSet의 값들을 Dto에 넣어주는 역할) 인터페이스가 들어가야 하는데 메소드가 하나뿐이라 간편하게 만든 것
//			JdbcDto dto = new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
//			return dto;
//		});
		
		try {
			list = jdbcTemplate.query(sql, new MyMapper());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public JdbcDto selectOne(int seq) {
		
		JdbcDto dto = null;
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD WHERE SEQ = ? ";

		try {
			dto = jdbcTemplate.queryForObject(sql, new MyMapper(), new Object[] {seq});			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}

	@Override
	public int insert(JdbcDto dto) {
		int res = 0;
		
		String sql = " INSERT INTO JDBCBOARD VALUES(JDBCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		try {
			res = jdbcTemplate.update(sql, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()}, new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(JdbcDto dto) {
		int res = 0;
		
		String sql = " UPDATE JDBCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
		
		try {
			res = jdbcTemplate.update(sql, new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()}, new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER});			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		
		String sql = " DELETE FROM JDBCBOARD WHERE SEQ = ? ";
		
		try {
			res = jdbcTemplate.update(sql, new Object[] {seq}, new int[] {Types.INTEGER});			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}

	
	// inner class impl RowMapper
	private static final class MyMapper implements RowMapper<JdbcDto> {

		@Override
		public JdbcDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}
	
}


