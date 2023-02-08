package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.vo.BlogVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	// 1. 특정 유저의 블로그 접속
	@RequestMapping("/{id}")
	public String main(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		return "blog/main";
	}
	
	// 2. 관리 페이지
	@RequestMapping("/{id}/adminbasic")	
	public String adminBasic(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		return "blog/admin-basic";
	}
	
	// 3. 관리 페이지 - 카테고리
	@RequestMapping("/{id}/admincategory")
	public String admincategory(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		return "blog/admin-category";
	}
	
	// 4. 관리 페이지 - 글쓰기
	@RequestMapping("/{id}/adminwrite")
	public String adminwrite(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		return "blog/admin-write";
	}
}
