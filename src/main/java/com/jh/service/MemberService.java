package com.jh.service;

import com.jh.dto.MemberDto;

public interface MemberService {
	boolean loginCheck(String id, String pw);
	boolean registerMember(MemberDto dto);
	int testPointUp();
	int testMemberCount(MemberDto dto);
	MemberDto testUserInfo(MemberDto dto);
	int testPointAdd(String id);
}
