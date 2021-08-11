package com.jh.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.dto.MemberDto;
import com.jh.service.MemberService;
import com.jh.util.MyJob;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/")
	public String homeLogin(Locale locale, Model model) {
		return "homeLogin";
	}
	
	@RequestMapping(value = "/loginAction")	
	public String loginAction(String id, String pw, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto dto = new MemberDto();
		dto.setId(id);
		boolean result = memberService.loginCheck(id, pw);
		String ret = "";
		if(result) {
			session.setAttribute("id", id);
			dto = memberService.testUserInfo(dto);
			request.setAttribute("userName", dto.getName());
			request.setAttribute("userPoint", dto.getPoint());
			if("admin".equals(id)) {
				ret="adminPage";
			}else {
				request.setAttribute("msg","로그인성공! 메인페이지로 이동합니다.");
				ret="mainPage";
			}
		}else {
			request.setAttribute("msg","아아디/비밀번호 확인해주세요.");
			ret="homeLogin";
			
		}
		return ret;
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerAction")
	public String registerAction(MemberDto dto, HttpServletRequest request) {
		memberService.registerMember(dto);
		request.setAttribute("msg", "가입되었습니다. 로그인해주세요");
		return "homeLogin";
	}
	
	@RequestMapping(value = "/logoutAction")
	public String logoutAction(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/getPoint")
	public String getPoint(String id, HttpServletRequest request) {
		request.getParameter(id);
		memberService.testPointAdd(id);
		request.setAttribute("msg", "1000점이 적립되었습니다.");
		return "mainPage";
	}
	
	@RequestMapping(value = "/start")  // 스케줄러 시작할게요 (= 10초마다 MyJob 실행할게요).
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("스케줄러가 시작됨.");
		return "homeLogin";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("스케줄러가 종료됨.");
		return "homeLogin";
	}

	
	
	
}
