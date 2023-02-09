package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	// 1. 특정 유저의 블로그 접속
	@RequestMapping("/{id}")
	public String main(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		
		List<CategoryVo> list = categoryService.findAll(id);
		model.addAttribute("list", list);
		
		List<PostVo> postList = postService.findAll(id);
		model.addAttribute("postList", postList);
		
		PostVo postVo = postService.findOne(id);
		model.addAttribute("postVo", postVo);
		
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
		
		List<CategoryVo> list = categoryService.findAll(id);
		model.addAttribute("list", list);
		return "blog/admin-category";
	}
	
	// 4. 관리 페이지 - 글쓰기
	@RequestMapping("/{id}/adminwrite")
	public String adminwrite(@PathVariable("id") String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		
		List<CategoryVo> list = categoryService.findAll(id);
		model.addAttribute("list", list);
		return "blog/admin-write";
	}
	
	// 5. 카테고리 추가
	@RequestMapping("/{id}/categoryadd")
	public String categoryadd(@PathVariable("id") String id, @RequestParam("name") String name) {
		CategoryVo vo = new CategoryVo();
		vo.setId(id);
		vo.setName(name);
		categoryService.addCategory(vo);
		
		return "redirect:/" + id + "/admincategory";
	}
	
	// 6. 글쓰기
	@RequestMapping("/{id}/write")
	public String write(@PathVariable("id") String id, 
			@RequestParam("category") String categoryName, PostVo vo) {
		
		CategoryVo categoryVo = categoryService.findByName(categoryName);
		vo.setCategoryNo(categoryVo.getNo());
		postService.addPost(vo);
		
		return "redirect:/" + id;
	}
}
