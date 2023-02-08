package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	// 1. 회원가입 페이지 이동
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
		
	// 2. 회원가입
	// -> 회원가입 하면 회원가입 성공페이지로 이동
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		userService.join(vo);
		blogService.newBlog(vo.getId());
		return "user/joinsuccess";
	}
	
	// 3. 로그인 페이지 이동
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	// 4. 로그인
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(UserVo vo, Model model) {
		BlogVo blogVo = blogService.getBlog(vo.getId());
		model.addAttribute("vo", blogVo);
		return "blog/main";
	}
}
