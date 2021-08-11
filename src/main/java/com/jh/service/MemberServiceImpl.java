package com.jh.service;

import javax.swing.undo.AbstractUndoableEdit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.dao.MemberDao;
import com.jh.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	
	
	@Override
	public boolean loginCheck(String id, String pw) {
		int result = dao.loginCheck(id,pw);
		return result==1;
	}

	@Override
	public boolean registerMember(MemberDto dto) {
		int result = dao.insert(dto);
		return result==1;
	}

	@Override
	public int testPointUp() {
		int result = dao.pointUp();
		return result;
	}

	@Override
	public int testMemberCount(MemberDto dto) {
		int result = dao.memberCount(dto);
		return result;
	}

	@Override
	public MemberDto testUserInfo(MemberDto dto) {
		return dao.userInfo(dto);
	}

	@Override
	public int testPointAdd(String id) {
		int result = dao.pointAdd(id);
		return result;
	}


}
