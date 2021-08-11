package com.jh.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jh.dao.MemberDao;
import com.jh.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testLoginCheck() throws Exception {
		int result = dao.loginCheck("admin", "1234");
		System.out.println(result);
		result = dao.loginCheck("admin", "123");
		System.out.println(result);
	}
	
	@Test
	public void testRegisterAction() throws Exception{
		int result = dao.insert(new MemberDto("aa", "1234", "사용자"));
		if(result==1) {
			System.out.println("회원가입 성공!");
		}
	}
	
}
 