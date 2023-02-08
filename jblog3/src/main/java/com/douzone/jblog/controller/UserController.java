package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
		return "user/joinsuccess";
	}
}
