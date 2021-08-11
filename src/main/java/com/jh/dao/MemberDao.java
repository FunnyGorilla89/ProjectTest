package com.jh.dao;

import com.jh.dto.MemberDto;

public interface MemberDao {
	int loginCheck(String id, String pw);
	int insert(MemberDto dto);
	int pointUp();
	int memberCount(MemberDto dto);
	MemberDto userInfo(MemberDto dto);
	int pointAdd(String id);
}
