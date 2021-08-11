package com.jh.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.jh.dto.MemberDto;
import com.jh.service.MemberService;
import com.jh.service.MemberServiceImpl;

public class MyJob implements Job {
	@Autowired
	MemberDto dto;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext(); 
		MemberService service= ctx.getBean(MemberServiceImpl.class);
		
		service.testPointUp();	
		 int result = 0;
		 result = service.testMemberCount(dto);
		System.out.println("Quartz의 Job이 실행됨/ " + result + "명에게 포인트 1점 부여");
	}

}