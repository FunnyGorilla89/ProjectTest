package com.jh.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	private static final String ns = "com.jh.mapper.memberMapper";
	
	@Override
	public int loginCheck(String id, String pw) {
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("id", id);
		map1.put("pw", pw);
		int result = sqlSession.selectOne(ns +".loginCheck",map1);
		return result;
	}

	@Override
	public int insert(MemberDto dto) {
		return sqlSession.insert(ns + ".insertMember", dto);
	}

	@Override
	public int pointUp() {
		return sqlSession.update(ns + ".pointUpdate");
	}

	@Override
	public int memberCount(MemberDto dto) {
		return sqlSession.selectOne(ns +".allMember",dto);
	}

	@Override
	public MemberDto userInfo(MemberDto dto) {
		return sqlSession.selectOne(ns + ".userInfo", dto);
	}

	@Override
	public int pointAdd(String id) {
		return sqlSession.update(ns + ".pointAdd", id);
	}



}
