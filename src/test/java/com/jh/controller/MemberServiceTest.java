package com.jh.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jh.dto.MemberDto;
import com.jh.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	@Autowired
	private MemberService service;
	
	@Test
	public void testLoginCheck() throws Exception {
		System.out.println(service.loginCheck("admin", "1234"));
		System.out.println(service.loginCheck("admi", "1234"));
	}
	
	@Test
	public void testRegisterMemberService() throws Exception {
		System.out.println(service.registerMember(new MemberDto("bb", "1234", "사용자1")));
		System.out.println(service.registerMember(new MemberDto("bb", "12345", "사용자2")));		
	}
}
 