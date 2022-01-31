package com.hatsnake.ever.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

	private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	// 글작성
	@GetMapping("/article/write")
	public String writeForm() {
		logger.info("ArticleController.writeForm() 함수 시작");
		
		return "article/articleWrite";
	}

	// 글리스트
	@GetMapping("/article/list")
	public String list() {
		logger.info("ArticleController.list() 함수 시작");
		
		return "article/articleList";
	}

	// 상세글
	@GetMapping("/article/view")
	public String view() {
		logger.info("ArticleController.view() 함수 시작");
		
		return "article/articleView";
	}
}